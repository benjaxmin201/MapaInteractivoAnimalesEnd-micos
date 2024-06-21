package com.generation.mapaendemico.service;

import com.generation.mapaendemico.models.Fauna;
import com.generation.mapaendemico.repository.FaunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaunaService {
    @Autowired
    private FaunaRepository faunarepository;

    public Fauna getFaunaById(Integer id) {
        return faunarepository.getReferenceById(id);
    }
}