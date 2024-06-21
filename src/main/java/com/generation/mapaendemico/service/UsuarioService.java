package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Usuario;
import com.generation.mapaendemico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuariosRepository;

    public Usuario getUsuarioById(Integer id) {
        return usuariosRepository.getReferenceById(id);
    }
}