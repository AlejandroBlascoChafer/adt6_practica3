package org.simarro.adt6_practica3.service;

import org.simarro.adt6_practica3.model.Usuario;
import org.simarro.adt6_practica3.model.dto.UsuarioRequestDTO;
import org.simarro.adt6_practica3.model.dto.UsuarioResponseDTO;

import java.util.List;

public interface IUsuarioService {
    UsuarioResponseDTO findByUsuario(Integer idUsuario);
    List<UsuarioResponseDTO> findAll();
    Usuario registrar(UsuarioRequestDTO usuario);
    Usuario modificar(UsuarioRequestDTO usuario);
    void eliminar(Integer id);
}
