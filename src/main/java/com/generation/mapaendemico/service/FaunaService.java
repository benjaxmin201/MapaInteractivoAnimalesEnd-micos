package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Fauna;
import com.generation.mapaendemico.repository.FaunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FaunaService {
    private final FaunaRepository faunaRepository;

    @Autowired
    public FaunaService(FaunaRepository faunaRepository) {
        this.faunaRepository = faunaRepository;
    }

    public List<Fauna> getAllFauna() {
        return faunaRepository.findAll();
    }

    public Fauna getFaunaById(Long id) {
        return faunaRepository.findById(id).orElse(null);
    }

    public Fauna getFaunaByNombreComun(String nombreComun) {
        return faunaRepository.findByNombreComun(nombreComun);
    }

    public Fauna getFaunaByNombreCientifico(String nombreCientifico) {
        return faunaRepository.findByNombreCientifico(nombreCientifico);
    }

    public List<Fauna> getFaunaByAmenaza(String amenaza) {
        return faunaRepository.findByAmenaza(amenaza);
    }

    public Fauna saveFauna(Fauna fauna) {
        return faunaRepository.save(fauna);
    }

    public Fauna updateFauna(Fauna fauna) {
        return faunaRepository.save(fauna);
    }

    public void deleteFauna(long id) {
            faunaRepository.deleteById(id);
    }
}