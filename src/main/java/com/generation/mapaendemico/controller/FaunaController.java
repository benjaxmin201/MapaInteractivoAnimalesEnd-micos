package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.dto.FaunaDTO;
import com.generation.mapaendemico.models.Fauna;
import com.generation.mapaendemico.service.FaunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fauna")
public class FaunaController {
    private final FaunaService faunaService;

    @Autowired
    public FaunaController(FaunaService faunaService) {
        this.faunaService = faunaService;
    }

    private FaunaDTO convertToDTO(Fauna fauna) {
        return FaunaDTO.builder()
                .nombreCientifico(fauna.getNombreCientifico())
                .nombreComun(fauna.getNombreComun())
                .clase(fauna.getClase())
                .orden(fauna.getOrden())
                .familia(fauna.getFamilia())
                .regiones(fauna.getRegiones())
                .amenaza(fauna.getAmenaza())
                .vertebradoInvertebrado(fauna.getVertebradoInvertebrado())
                .descripcion(fauna.getDescripcion())
                .peso(fauna.getPeso())
                .build();
    }

    private Fauna convertToEntity(FaunaDTO faunaDTO) {
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
        return fauna;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<FaunaDTO>> getAllFauna() {
        List<Fauna> faunaList = faunaService.getAllFauna();
        List<FaunaDTO> faunaDTOList = faunaList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(faunaDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaunaDTO> getFaunaById(@PathVariable long id) {
        Fauna fauna = faunaService.getFaunaById(id);
        if (fauna != null) {
            return new ResponseEntity<>(convertToDTO(fauna), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombre/comun/{nombreComun}")
    public ResponseEntity<FaunaDTO> getFaunaByNombreComun(@PathVariable String nombreComun) {
        Fauna fauna = faunaService.getFaunaByNombreComun(nombreComun);
        return fauna != null ? new ResponseEntity<>(convertToDTO(fauna), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/nombre/cientifico/{nombreCientifico}")
    public ResponseEntity<FaunaDTO> getFaunaByNombreCientifico(@PathVariable String nombreCientifico) {
        Fauna fauna = faunaService.getFaunaByNombreCientifico(nombreCientifico);
        return fauna != null ? new ResponseEntity<>(convertToDTO(fauna), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/amenaza/{amenaza}")
    public ResponseEntity<List<FaunaDTO>> getFaunaByAmenaza(@PathVariable String amenaza) {
        List<FaunaDTO> fauntaDTOList = faunaService.getFaunaByAmenaza(amenaza).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(fauntaDTOList, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<FaunaDTO> createFauna(@Valid @RequestBody FaunaDTO faunaDTO) {
        Fauna fauna = convertToEntity(faunaDTO);
        Fauna nuevaFauna = faunaService.saveFauna(fauna);
        return new ResponseEntity<>(convertToDTO(nuevaFauna), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<FaunaDTO> updateFauna(@PathVariable long id, @Valid @RequestBody FaunaDTO faunaDTO) {
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
            Fauna actualizarFauna = faunaService.updateFauna(fauna);
            return new ResponseEntity<>(convertToDTO(actualizarFauna), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteFauna(@PathVariable long id) {
        Fauna fauna = faunaService.getFaunaById(id);
        if (fauna != null) {
            faunaService.deleteFauna(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}