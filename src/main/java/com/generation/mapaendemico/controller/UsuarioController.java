package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.dto.UsuarioDTO;
import com.generation.mapaendemico.models.Usuario;
import com.generation.mapaendemico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public Usuario createUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setCorreo(usuarioDTO.getCorreo());
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario != null) {
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setPassword(usuarioDTO.getPassword());
            usuario.setCorreo(usuarioDTO.getCorreo());
            return usuarioService.saveUsuario(usuario);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable long id) {
        usuarioService.deleteUsuario(id);
    }
}
