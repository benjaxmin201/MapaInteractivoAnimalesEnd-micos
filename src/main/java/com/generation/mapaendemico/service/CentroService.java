package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Centro;
import com.generation.mapaendemico.repository.CentroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentroService {

    @Autowired
    private CentroRepository centroRepository;

    public Centro obtenerCentroPorId(Integer id) {
        return centroRepository.getReferenceById(id);
    }

    public Centro obtenerCentroPorNombre(String nombre) {
        return centroRepository.findByNombre(nombre);
    }
}
