package com.generation.mapaendemico.service;

import com.generation.mapaendemico.dto.CentroDTO;
import com.generation.mapaendemico.models.Centro;
import com.generation.mapaendemico.repository.CentroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentroService {

    @Autowired
    private CentroRepository centroRepository;

    public Centro obtenerCentroPorId(Long id) {
        return centroRepository.getReferenceById(id.intValue());
    }

    public Centro obtenerCentroPorNombre(String nombre) {
        return centroRepository.findByNombre(nombre);
    }

    @Transactional
    public CentroDTO guardarNuevoCentro(CentroDTO nuevoCentro) {
        Centro centroParaGuardar = Centro.builder()
                .nombre(nuevoCentro.getNombreCentro())
                .tipocentro(nuevoCentro.getTipocentroCentro())
                .direccion(nuevoCentro.getDireccionCentro())
                .build();
        centroRepository.save(centroParaGuardar);

        return nuevoCentro;
    }

    @Transactional
    public CentroDTO editarCentroPorNombre(CentroDTO centroEditado, String nombre) {
        Centro centroActualizar = centroRepository.findByNombre(nombre);
        centroActualizar.setNombre(centroEditado.getNombreCentro());
        centroActualizar.setTipocentro(centroEditado.getTipocentroCentro());
        centroActualizar.setDireccion(centroEditado.getDireccionCentro());
        centroRepository.save(centroActualizar);
        return centroEditado;
    }

    @Transactional
    public void borrarCentroPorId(Integer id) {
        if (centroRepository.existsById(id)) {
            centroRepository.deleteById(id);
        }
        System.out.println("Centro no existe");
    }
}
