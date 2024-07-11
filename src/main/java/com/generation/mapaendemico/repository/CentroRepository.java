package com.generation.mapaendemico.repository;

import com.generation.mapaendemico.models.Centro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentroRepository extends JpaRepository<Centro, Long> {
    Centro findByNombre(String nombre);
    Centro findByTipo(String tipocentro);
}
