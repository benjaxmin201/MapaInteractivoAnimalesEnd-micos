package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.dto.CentroDTO;
import com.generation.mapaendemico.models.Centro;
import com.generation.mapaendemico.service.CentroService;
import com.generation.mapaendemico.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/centros")
public class CentroController {
    private final CentroService centroService;
    private final RegionService regionService;

    @Autowired
    public CentroController(CentroService centroService, RegionService regionService) {
        this.centroService = centroService;
        this.regionService = regionService;
    }

    private CentroDTO convertToDTO(Centro centro) {
        return CentroDTO.builder()
                .nombre(centro.getNombre())
                .tipocentro(centro.getTipo())
                .direccion(centro.getDireccion())
                .build();
    }

    private Centro convertToEntity(CentroDTO centroDTO) {
        Centro centro = new Centro();
        centro.setNombre(centroDTO.getNombre());
        centro.setTipo(centroDTO.getTipocentro());
        centro.setDireccion(centroDTO.getDireccion());
        return centro;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<CentroDTO>> getAllCentros() {
        List<Centro> centros = centroService.getAllCentros();
        List<CentroDTO> centroDTOs = centros.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(centroDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CentroDTO> getCentroById(@PathVariable("id") Long id) {
        Centro centro = centroService.getCentroById(id);
        return centro != null ? new ResponseEntity<>(convertToDTO(centro), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<CentroDTO> getCentroByNombre(@PathVariable("nombre") String nombre) {
        Centro centro = centroService.getCentroByNombre(nombre);
        return centro != null ? new ResponseEntity<>(convertToDTO(centro), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tipo/{tipocentro}")
    public ResponseEntity<CentroDTO> getCentroByTipo(@PathVariable("tipo") String tipo) {
        Centro centro = centroService.getCentroByTipo(tipo);
        return centro != null ? new ResponseEntity<>(convertToDTO(centro), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/crear")
    public ResponseEntity<?> createCentro(@Valid @RequestBody CentroDTO centroDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos de entrada incorrectos");
        }

        Centro centro = convertToEntity(centroDTO);
        Centro newCentro = centroService.saveCentro(centro);
        CentroDTO newCentroDTO = convertToDTO(newCentro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCentroDTO);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CentroDTO> updateCentro(@PathVariable("id") Long id,
                                                  @Valid @RequestBody CentroDTO centroDTO,
                                                  BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        Centro existingCentro = centroService.getCentroById(id);
        if (existingCentro == null) {
            return ResponseEntity.notFound().build();
        }

        Centro centroToUpdate = convertToEntity(centroDTO);
        centroToUpdate.setId(id);
        Centro updatedCentro = centroService.updateCentro(centroToUpdate);
        CentroDTO updatedCentroDTO = convertToDTO(updatedCentro);
        return ResponseEntity.ok(updatedCentroDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteCentro(@PathVariable("id") Long id) {
        if (centroService.getCentroById(id) != null) {
            regionService.deleteRegion(id);
            return new  ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
