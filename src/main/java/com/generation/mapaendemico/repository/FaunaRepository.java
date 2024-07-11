package com.generation.mapaendemico.repository;

import com.generation.mapaendemico.models.Fauna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaunaRepository extends JpaRepository<Fauna, Long> {
    Fauna findByNombreComun(String nombreComun);
    Fauna findByNombreCientifico(String nombreCientifico);
    List<Fauna> findByAmenaza(String amenaza);
}
