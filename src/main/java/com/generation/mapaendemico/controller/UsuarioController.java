package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.dto.UsuarioDTO;
import com.generation.mapaendemico.models.Usuario;
import com.generation.mapaendemico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    };

    private UsuarioDTO convertToDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .nombre(usuario.getNombre())
                .password(usuario.getPassword())
                .correo(usuario.getCorreo())
                .build();
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nombre(usuarioDTO.getNombre())
                .password(usuarioDTO.getPassword())
                .correo(usuarioDTO.getCorreo())
                .build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        List<Usuario> usuariosList = usuarioService.getAllUsuarios();
        List<UsuarioDTO> usuarioDTOList = usuariosList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(usuarioDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        return usuario != null ? new ResponseEntity<>(convertToDTO(usuario), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<UsuarioDTO> getUsuarioByNombre(@PathVariable String nombre) {
        Usuario usuario = usuarioService.getUsuarioByNombre(nombre);
        return usuario != null ? new ResponseEntity<>(convertToDTO(usuario), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuarioDTO> getUsuarioByEmail(@PathVariable String correo) {
        Usuario usuario = usuarioService.getUsuarioByCorreo(correo);
        return usuario != null ? new ResponseEntity<>(convertToDTO(usuario), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/password/{password}")
    public ResponseEntity<UsuarioDTO> getUsuarioByPassword(@PathVariable String password) {
        Usuario usuario = usuarioService.getUsuarioByPassword(password);
        return usuario != null ? new ResponseEntity<>(convertToDTO(usuario), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear")
    public ResponseEntity<UsuarioDTO> createUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.saveUsuario(convertToEntity(usuarioDTO));
        return new ResponseEntity<>(convertToDTO(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario != null) {
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setPassword(usuarioDTO.getPassword());
            usuario.setCorreo(usuarioDTO.getCorreo());

            Usuario actualizarUsuario = usuarioService.saveUsuario(usuario);
            UsuarioDTO actualizarUsuarioDTO = convertToDTO(actualizarUsuario);
            return new ResponseEntity<>(actualizarUsuarioDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable long id) {
        if (usuarioService.getUsuarioById(id) != null) {
            usuarioService.deleteUsuario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
