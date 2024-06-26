package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.dto.ParqueDTO;
import com.generation.mapaendemico.models.Parque;
import com.generation.mapaendemico.service.ParqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("api/parques")
public class ParqueController {
    @Autowired
    private ParqueService parqueService;
    @GetMapping("/nombre")
    public String getParqueByNombre(@PathVariable String nombre){
        Parque parqueSolicitado = parqueService.findByNombre(nombre);
        return parqueSolicitado.getNombre();
    }


    @PostMapping("/nuevoParque")
    public Parque createParque(@RequestBody Parque parque) {
        return parqueService.createParque(parque);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateParqueByName(@PathVariable String nombre, @RequestBody
                                                     @Valid ParqueDTO parqueParaActualizar, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Verifica los campos antes de actualizar", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(parqueService.updateParqueByName(parqueParaActualizar, nombre),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/nombre")
    public ResponseEntity<?>deleteByNombre(@PathVariable String nombre) {
        parqueService.deleteByNombre(nombre);
        return new ResponseEntity<>("Parque borrado exitosamente", HttpStatus.OK);
    }
}