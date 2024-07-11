package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Parque;
import com.generation.mapaendemico.repository.ParqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class ParqueService {
    private final ParqueRepository parqueRepository;

    @Autowired
    public ParqueService(ParqueRepository parqueRepository) {
        this.parqueRepository = parqueRepository;
    }

    public List<Parque> getAllParques() {
        return parqueRepository.findAll();
    }

    public Parque getParqueById(Long id) {
        return parqueRepository.findById(id).orElse(null);
    }

    public Parque getParqueByNombre(String nombre) {
        return parqueRepository.findByNombre(nombre);
    }

    public Parque createParque(Parque parque) {
        return parqueRepository.save(parque);
    }

    public Parque updateParque(Parque parque) {
        return parqueRepository.save(parque);
    }

    public void deleteParque(Long id) {
        if (parqueRepository.existsById(id)) {
            parqueRepository.deleteById(id);
        }
    }

}