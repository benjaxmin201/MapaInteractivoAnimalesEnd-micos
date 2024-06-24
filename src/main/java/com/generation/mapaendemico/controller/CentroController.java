package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.dto.CentroDTO;
import com.generation.mapaendemico.models.Centro;
import com.generation.mapaendemico.service.CentroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/centros")
public class CentroController {

    @Autowired
    private CentroService centroService;

    //Método a ejecutarse al momento de ingresar a la ruta
    @GetMapping("/")
    public String getUsuarioById() {
        Centro centroSolicitado = centroService.obtenerCentroPorId(1L);
        return "Hola soy " + centroSolicitado.getNombre() ;
    }

    @GetMapping("/{nombre}")
    public String getCentroByNombre(@PathVariable String nombre) {
        Centro centroSolicitado = centroService.obtenerCentroPorNombre(nombre);
        return "El centro que busca "
                + centroSolicitado.getNombre()
                + " se ubica en "
                + centroSolicitado.getDireccion();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> guardarCentro(@RequestBody @Valid CentroDTO nuevoCentro, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity<>("Verifique los campos", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(centroService.guardarNuevoCentro(nuevoCentro), HttpStatus.CREATED);
    }

    @PutMapping("/editar/{correo}")
    public ResponseEntity<?> editarCentroPorNombre(@PathVariable String nombre,
                                                    @RequestBody @Valid CentroDTO centroParaEditar,
                                                    BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Verifica los campos antes de editar", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(centroService.editarCentroPorNombre(centroParaEditar, nombre),
                HttpStatus.OK);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrarPorId(@RequestParam Integer id) {
        centroService.borrarCentroPorId(id);
        return new ResponseEntity<>("Usuario borrado exitosamente", HttpStatus.OK);
    }
}
