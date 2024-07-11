package com.generation.mapaendemico.dto;

import javax.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CentroDTO {

    @Pattern(regexp ="^[a-zA-Z]{2,50}$", message = "Campo incorrecto")
    @Size(min = 2, max = 50, message = "El nombre debe tener una longitud entre 2 a 50 caracteres")
    private String nombre;

    @Pattern(regexp ="^[a-zA-Z]{2,20}$", message = "Campo incorrecto")
    @Size(min = 2, max = 20, message = "El nombre debe tener una longitud entre 2 a 20 caracteres")
    private String tipocentro;

    @Pattern(regexp ="^[a-zA-Z]{2,20}$", message = "Campo incorrecto")
    @Size(min = 2, max = 100)
    private String direccion;
}
