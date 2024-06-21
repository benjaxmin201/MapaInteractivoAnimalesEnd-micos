package com.generation.mapaendemico.repository;

import com.generation.mapaendemico.models.Centro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroRepository extends JpaRepository<Centro, Integer> {

    Centro findByNombre(String nombre);
}
