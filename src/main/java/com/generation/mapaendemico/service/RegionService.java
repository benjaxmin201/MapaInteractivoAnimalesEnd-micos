package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Region;
import com.generation.mapaendemico.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public Region getRegionById(Long id) {
        return regionRepository.getReferenceById(id);
    }

    public Region actualizarRegion(Region region) {
        return regionRepository.save(region);
    }


    public List<String> obtenerRegiones() {
        return List.of("regiones");
    }

    public Region saveRegion(Region region) {
        return null;
    }
}
