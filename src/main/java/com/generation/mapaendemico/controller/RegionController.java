package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.dto.RegionDTO;
import com.generation.mapaendemico.models.Region;
import com.generation.mapaendemico.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("api/regiones")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("/regionSolicitada")
    public String getRegionById() {
        Region regionSolicitada = regionService.getRegionById(Long id);
        return regionSolicitada.getNombre();
    }

    @GetMapping("/regiones")
    public List<String> obtenerRegiones() {
        return regionService.obtenerRegiones();
    }

    @PostMapping("/regionNueva")
    public Region crearRegion(@Valid @RequestBody RegionDTO regionDTO) {
        Region region = new Region();
        region.setNumero(regionDTO.getNumeroRegion());
        region.setNombre(regionDTO.getNombreRegion());
        region.setImagenRegion(regionDTO.getImagenRegion());
        return regionService.saveRegion(region);
    }

    @PutMapping("/regionExistente")
    public ResponseEntity<?> actualizarRegion(@PathVariable long id, @RequestBody Region regionActualizada) {
        Region regionExistente = regionService.getRegionById(id);
        if (regionExistente == null) {
            return ResponseEntity.notFound().build();
        }
        regionExistente.setNombre(regionActualizada.getNombre());

        Region regionActualizadaNueva = regionService.actualizarRegion(regionExistente);
        return ResponseEntity.ok(regionActualizadaNueva);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<?> borrarPorId(@RequestParam Long id) {
        regionService.getRegionById(id);
        return new ResponseEntity<>("Región borrada exitosamente", HttpStatus.OK);
    }
}
