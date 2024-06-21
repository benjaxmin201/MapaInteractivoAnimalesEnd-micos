package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Region;
import com.generation.mapaendemico.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public Region getRegionById(Integer id) {
        return regionRepository.getReferenceById(id);
    }
}
