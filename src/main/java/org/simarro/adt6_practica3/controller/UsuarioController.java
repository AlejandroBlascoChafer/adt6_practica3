package org.simarro.adt6_practica3.controller;

import jakarta.validation.Valid;
import org.simarro.adt6_practica3.model.Usuario;
import org.simarro.adt6_practica3.model.dto.UsuarioRequestDTO;
import org.simarro.adt6_practica3.model.dto.UsuarioResponseDTO;
import org.simarro.adt6_practica3.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> listarPorId(@PathVariable("id") Integer id){

        return new ResponseEntity<>(service.findByUsuario(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> registrar(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){

        return new ResponseEntity<>(service.registrar(usuarioRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificar(@PathVariable Integer id, @Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        if (service.modificar(id, usuarioRequestDTO) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.modificar(id, usuarioRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
