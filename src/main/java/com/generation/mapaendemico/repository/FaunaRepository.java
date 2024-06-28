package com.generation.mapaendemico.repository;

import com.generation.mapaendemico.models.Fauna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaunaRepository extends JpaRepository<Fauna, Integer> {
    Fauna findById(Integer id);
    Fauna findByNombreCientifico(String nombreCientifico);
    Fauna findByNombreComun(String nombreComun);
    Fauna findByClase(String clase);
    Fauna findByOrden(String orden);
    Fauna findByFamilia(String familia);
    Fauna findByRegiones(String regiones);
    Fauna findByAmenaza(String amenaza);
    Fauna findByVertebradoInvertebrado(String vertebradoInvertebrado);
    Fauna findByDescripcion(String descripcion);
    Fauna findByPeso(Integer peso);
    Fauna findByAltura(Integer altura);
    Fauna findByParquesId(Integer parquesId);
}
