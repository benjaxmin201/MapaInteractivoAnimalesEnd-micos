package com.generation.mapaendemico.repository;

import com.generation.mapaendemico.models.Parque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParqueRepository extends JpaRepository<Parque, Integer>
{
    Parque findByNombre(String nombre);
    Parque findById(int id);

    void deleteByNombre(String nombre);
}