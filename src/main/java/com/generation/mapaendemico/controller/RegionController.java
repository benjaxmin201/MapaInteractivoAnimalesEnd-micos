package com.generation.mapaendemico.controller;

import com.generation.mapaendemico.models.Region;
import com.generation.mapaendemico.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("api/regiones")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("/api/regiones")
    public String getRegionById() {
        Region regionSolicitada = regionService.getRegionById(Long id);
        return regionSolicitada.getNombre();
    }

    //@PostMapping

    @PutMapping("/api/regiones")
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
