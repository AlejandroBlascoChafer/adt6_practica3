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

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarPorId(@PathVariable("id") Integer id){

        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> registrar(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        if
        return new ResponseEntity<>(service.registrar(usuarioRequestDTO), HttpStatus.OK);
    }
}
