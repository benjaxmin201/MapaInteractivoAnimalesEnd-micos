package com.generation.mapaendemico.repository;

import com.generation.mapaendemico.models.Parque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParqueRepository extends JpaRepository<Parque, Integer> {
}
