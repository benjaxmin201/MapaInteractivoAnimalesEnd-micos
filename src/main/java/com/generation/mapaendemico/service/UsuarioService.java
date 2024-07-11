package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Usuario;
import com.generation.mapaendemico.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.usuarioRepository = repository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario getUsuarioByNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    public Usuario getUsuarioByPassword(String password) {
        return usuarioRepository.findByPassword(password);
    }

    public Usuario getUsuarioByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
            usuarioRepository.deleteById(id);
    }
}
