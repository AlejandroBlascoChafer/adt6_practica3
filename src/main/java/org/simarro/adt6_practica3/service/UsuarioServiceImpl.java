package org.simarro.adt6_practica3.service;

import org.modelmapper.ModelMapper;
import org.simarro.adt6_practica3.model.Usuario;
import org.simarro.adt6_practica3.model.dto.UsuarioRequestDTO;
import org.simarro.adt6_practica3.model.dto.UsuarioResponseDTO;
import org.simarro.adt6_practica3.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private IUsuarioRepository repo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UsuarioResponseDTO findByUsuario(Integer idUsuario) {
        Optional<Usuario> op = repo.findById(idUsuario);

        if (op.isPresent()){
            return modelMapper.map(op.get(), UsuarioResponseDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public List<UsuarioResponseDTO> findAll() {

        return repo.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioResponseDTO.class))
                .collect(Collectors.toList());

//        List<Usuario> usuarios = repo.findAll();
//        List<UsuarioResponseDTO> listaFinal = new ArrayList<>();
//        for (Usuario u: usuarios){
//            UsuarioResponseDTO usuarioResponseDTO = modelMapper.map(u, UsuarioResponseDTO.class);
//            listaFinal.add(usuarioResponseDTO);
//        }
//        return listaFinal;
    }

    @Override
    public Usuario registrar(UsuarioRequestDTO usuario) {
        Usuario usu = modelMapper.map(usuario, Usuario.class);
        usu.setFechaCreacion(LocalDate.now());
        return usu;
    }

    @Override
    public Usuario modificar(Integer id, UsuarioRequestDTO usuario) {
        Optional<Usuario> op = repo.findById(id);

        if (op.isPresent()) {

            Usuario usuMod = op.get();
            usuMod.setNombre(usuario.getNombre());
            usuMod.setApellidos(usuario.getApellidos());
            usuMod.setEmail(usuario.getEmail());
            usuMod.setPassword(usuario.getPassword());

            return repo.save(usuMod);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
