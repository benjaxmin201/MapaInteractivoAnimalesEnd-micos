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
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/regiones")
public class RegionController {
    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    private RegionDTO convertToDTO(Region region) {
        return RegionDTO.builder()
                .nombre(region.getNombre())
                .numero(region.getNumero())
                .build();
    }

    private Region convertToEntity(RegionDTO regionDTO) {
        Region region = new Region();
        region.setNombre(regionDTO.getNombre());
        region.setNumero(regionDTO.getNumero());
        return region;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<RegionDTO>> getAllRegiones() {
        List<Region> regionesList = regionService.getAllRegiones();
        List<RegionDTO> regionDTOList = regionesList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(regionDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionDTO> getRegionById(@PathVariable Long id) {
        Region region = regionService.getRegionById(id);
        return region != null ? new ResponseEntity<>(convertToDTO(region), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<RegionDTO> getRegionByNombre(@PathVariable String nombre) {
        Region region = regionService.getRegionByNombre(nombre);
        return region != null ? new ResponseEntity<>(convertToDTO(region), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear")
    public ResponseEntity<RegionDTO> createRegion(@Valid @RequestBody RegionDTO regionDTO) {
        Region region = regionService.saveRegion(convertToEntity(regionDTO));
        return new ResponseEntity<>(convertToDTO(region), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RegionDTO> updateRegion(@PathVariable Long id, @Valid @RequestBody RegionDTO regionDTO) {
        Region region = regionService.getRegionById(id);
        if (region != null) {
            region.setNombre(regionDTO.getNombre());
            region.setNumero(regionDTO.getNumero());
            Region actualizarRegion = regionService.saveRegion(region);
            RegionDTO actualizarRegionDTO = convertToDTO(actualizarRegion);
            return new ResponseEntity<>(actualizarRegionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        if (regionService.getRegionById(id) != null) {
            regionService.deleteRegion(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}