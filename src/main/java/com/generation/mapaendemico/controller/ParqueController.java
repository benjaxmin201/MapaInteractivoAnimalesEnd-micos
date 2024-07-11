package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.dto.ParqueDTO;
import com.generation.mapaendemico.models.Parque;
import com.generation.mapaendemico.service.ParqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/parques")
public class ParqueController {
    private final ParqueService parqueService;

    @Autowired
    public ParqueController(ParqueService parqueService) {
        this.parqueService = parqueService;
    }

    private ParqueDTO convertToDTO(Parque parque) {
        return ParqueDTO.builder()
                .nombre(parque.getNombre())
                .descripcion(parque.getDescripcion())
                .build();
    }

    private Parque convertToEntity(ParqueDTO parqueDTO) {
        Parque parque = new Parque();
        parque.setNombre(parqueDTO.getNombre());
        parque.setDescripcion(parqueDTO.getDescripcion());
        return parque;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ParqueDTO>> getAllParques() {
        List<Parque> parqueList = parqueService.getAllParques();
        List<ParqueDTO> parqueDTOList = parqueList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(parqueDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParqueDTO> findById(@PathVariable Long id) {
        Parque parque = parqueService.getParqueById(id);
        if (parque != null) {
            return new ResponseEntity<>(convertToDTO(parque), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ParqueDTO> findByNombre(@PathVariable String nombre) {
        Parque parque = parqueService.getParqueByNombre(nombre);
        if (parque != null) {
            return new ResponseEntity<>(convertToDTO(parque), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<ParqueDTO> createParque(@Valid @RequestBody ParqueDTO parqueDTO) {
        Parque parque = convertToEntity(parqueDTO);
        Parque nuevoParque = parqueService.createParque(parque);
        return new ResponseEntity<>(convertToDTO(nuevoParque), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ParqueDTO> updateParque(@PathVariable Long id, @Valid @RequestBody ParqueDTO parqueDTO) {
        Parque parqueExistente = parqueService.getParqueById(id);
        if (parqueExistente != null) {
            parqueExistente.setNombre(parqueDTO.getNombre());
            parqueExistente.setDescripcion(parqueDTO.getDescripcion());
            Parque parqueActualizado = parqueService.updateParque(parqueExistente);
            return new ResponseEntity<>(convertToDTO(parqueActualizado), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteParque(@PathVariable Long id) {
        if (parqueService.getParqueById(id) != null) {
            parqueService.deleteParque(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}