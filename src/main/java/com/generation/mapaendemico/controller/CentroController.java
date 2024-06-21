package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.models.Centro;
import com.generation.mapaendemico.service.CentroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
