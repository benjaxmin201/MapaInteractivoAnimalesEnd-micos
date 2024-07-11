package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Centro;
import com.generation.mapaendemico.repository.CentroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CentroService {

    @Autowired
    private CentroRepository centroRepository;

    public List<Centro> getAllCentros() {
        return centroRepository.findAll();
    }

    public Centro getCentroById(Long id) {
        return centroRepository.getReferenceById(id);
    }

    public Centro getCentroByNombre(String nombre) {
        return centroRepository.findByNombre(nombre);
    }

    public Centro getCentroByTipo(String tipo) {
        return centroRepository.findByTipo(tipo);
    }

    public Centro saveCentro(Centro centro) {
        return centroRepository.save(centro);
    }

    public Centro updateCentro(Centro centro) {
        return centroRepository.save(centro);
    }

    public void deleteCentro(Centro centro) {
        if (centroRepository.existsById(centro.getId())) {
            centroRepository.deleteById(centro.getId());
        }
    }
}
