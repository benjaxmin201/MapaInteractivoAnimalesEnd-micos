package com.generation.mapaendemico.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CentroDTO {

    @Pattern(regexp ="^[a-zA-Z]{2,50}$", message = "Campo incorrecto")
    @NotNull(message = "Este campo debe llenarse")//NotNull
    @Size(min = 2, max = 50, message = "El nombre debe tener una longitud entre 2 a 50 caracteres")
    private String nombreCentro;

    @Pattern(regexp ="^[a-zA-Z]{2,20}$", message = "Campo incorrecto")
    @Size(min = 2, max = 20, message = "El nombre debe tener una longitud entre 2 a 20 caracteres")
    private String tipocentroCentro;

    @Pattern(regexp ="^[a-zA-Z]{2,20}$", message = "Campo incorrecto")
    @NotNull(message = "Este campo debe llenarse")//NotNull
    @Size(min = 2, max = 20)
    private String direccionCentro;

}
