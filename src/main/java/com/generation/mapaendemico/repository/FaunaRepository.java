package com.generation.mapaendemico.repository;

import com.generation.mapaendemico.models.Fauna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaunaRepository extends JpaRepository<Fauna, Integer> {
}
