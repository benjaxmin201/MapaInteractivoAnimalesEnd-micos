package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Parque;
import com.generation.mapaendemico.repository.ParqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParqueService {
    @Autowired
    private ParqueRepository parqueRepository;

    public Parque getParqueById(Integer id) {
        return ParqueRepository.getReferenceById(id);
    }
}
