package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.dto.FaunaDTO;
import com.generation.mapaendemico.models.Fauna;
import com.generation.mapaendemico.service.FaunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.http.HttpStatus;
import org.springframework.beans.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/fauna")
public class FaunaController {
    @Autowired
    private FaunaService faunaService;

    @GetMapping("/{id}")
    public ResponseEntity<Fauna> getFaunaById(@PathVariable long id) {
        Fauna fauna = faunaService.getFaunaById(id);
        if (fauna != null) {
            return ResponseEntity.ok(fauna); 
        } else {
            return ResponseEntity.notFound().build();
        }  
    }

    @GetMapping
    public ResponseEntity<List<Fauna>> getFauna() {
        List<Fauna> faunaList = faunaService.getAllFauna();
        return ResponseEntity.ok(faunaList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fauna> updateFauna(@PathVariable long id, @Valid @RequestBody FaunaDTO faunaDTO) {
        Fauna fauna = faunaService.getFaunaById(id);
        if (fauna != null) {
            fauna.setNombreCientifico(faunaDTO.getNombreCientifico());
            fauna.setNombreComun(faunaDTO.getNombreComun());
            fauna.setClase(faunaDTO.getClase());
            fauna.setOrden(faunaDTO.getOrden());
            fauna.setFamilia(faunaDTO.getFamilia());
            fauna.setRegiones(faunaDTO.getRegiones());
            fauna.setAmenaza(faunaDTO.getAmenaza());
            fauna.setVertebradoInvertebrado(faunaDTO.getVertebradoInvertebrado());
            fauna.setDescripcion(faunaDTO.getDescripcion());
            fauna.setPeso(faunaDTO.getPeso());
            fauna.setAltura(faunaDTO.getAltura());
            faunaService.saveFauna(fauna);
            return ResponseEntity.ok(fauna);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Fauna> createFauna(@Valid @RequestBody FaunaDTO faunaDTO) {
        Fauna fauna = new Fauna();
        fauna.setNombreCientifico(faunaDTO.getNombreCientifico());
        fauna.setNombreComun(faunaDTO.getNombreComun());
        fauna.setClase(faunaDTO.getClase());
        fauna.setOrden(faunaDTO.getOrden());
        fauna.setFamilia(faunaDTO.getFamilia());
        fauna.setRegiones(faunaDTO.getRegiones());
        fauna.setAmenaza(faunaDTO.getAmenaza());
        fauna.setVertebradoInvertebrado(faunaDTO.getVertebradoInvertebrado());
        fauna.setDescripcion(faunaDTO.getDescripcion());
        fauna.setPeso(faunaDTO.getPeso());
        fauna.setAltura(faunaDTO.getAltura());
        faunaService.saveFauna(fauna);
        return ResponseEntity.status(HttpStatus.CREATED).body(fauna);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFauna(@PathVariable long id) {
        faunaService.deleteFauna(id);
        return ResponseEntity.noContent().build();
    }
}