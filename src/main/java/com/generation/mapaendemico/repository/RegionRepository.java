package com.generation.mapaendemico.repository;

import com.generation.mapaendemico.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    
    Region findById(Long id);
    Region findByNombre(String nombre);
    Region findByNumero(int numero);
    Region getReferenceById(Long id);
}
