package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Region;
import com.generation.mapaendemico.repository.RegionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RegionService {
    private final RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllRegiones() {
        return regionRepository.findAll();
    }

    public Region getRegionById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    public Region getRegionByNombre(String nombre) {
        return regionRepository.findByNombre(nombre);
    }

    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }


    public void deleteRegion(Long id) {
            regionRepository.deleteById(id);
    }
}
