package com.generation.mapaendemico.service;

import com.generation.mapaendemico.dto.ParqueDTO;
import com.generation.mapaendemico.models.Parque;
import com.generation.mapaendemico.repository.ParqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ParqueService {
    @Autowired
    private ParqueRepository parqueRepository;

    public Parque findById(int id) {
        return parqueRepository.findById(id);
    }
    @Transactional
    public Parque findByNombre(String nombre) {
        return parqueRepository.findByNombre(nombre);
    }

    @Transactional
    public Parque createParque(Parque parque) {
        return parqueRepository.save(parque);
    }

    @Transactional
    public ParqueDTO updateParqueByName(ParqueDTO parqueActualizado, String nombre) {
        Parque parqueActualizar = parqueRepository.findByNombre(nombre);
        parqueActualizar.setNombre(parqueActualizado.getNombreParque());
        parqueActualizar.setDescripcion(parqueActualizado.getDescripcionParque());
        parqueRepository.save(parqueActualizar);
        return parqueActualizado;
    }

    @Transactional
    public void deleteByNombre(String nombre) {
        parqueRepository.deleteByNombre(nombre);
    }

}