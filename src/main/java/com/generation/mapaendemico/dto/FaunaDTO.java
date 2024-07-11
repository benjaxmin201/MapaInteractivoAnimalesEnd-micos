package com.generation.mapaendemico.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FaunaDTO {
    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "ERROR: campo incorrecto")
    @Size(min = 2, max = 512, message = "ERROR: campo debe contener entre 2 a 512 caracteres")
    private String nombreCientifico;

    /*
    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "ERROR: campo incorrecto")
    @Size(min = 2, max = 512, message = "ERROR: campo debe contener entre 2 a 512 caracteres") */
    private String nombreComun;

    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "ERROR: campo incorrecto")
    @Size(min = 2, max = 512, message = "ERROR: campo debe contener entre 2 a 512 caracteres")
    private String clase;

    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "ERROR: campo incorrecto")
    @Size(min = 2, max = 512, message = "ERROR: campo debe contener entre 2 a 512 caracteres")
    private String orden;

    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "ERROR: campo incorrecto")
    @Size(min = 2, max = 512, message = "ERROR: campo debe contener entre 2 a 512 caracteres")
    private String familia;

    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "ERROR: campo incorrecto")
    @Size(min = 2, max = 512, message = "ERROR: campo debe contener entre 2 a 512 caracteres")
    private String regiones;

    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "ERROR: campo incorrecto")
    @Size(min = 2, max = 512, message = "ERROR: campo debe contener entre 2 a 512 caracteres")
    private String amenaza;

    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "ERROR: campo incorrecto")
    @Size(min = 2, max = 512, message = "ERROR: campo debe contener entre 2 a 512 caracteres")
    private String vertebradoInvertebrado;

    @Pattern(regexp = "^[a-zA-Z ]{2,50}$", message = "ERROR: campo incorrecto")
    @Size(min = 2, max = 1000, message = "ERROR: campo debe contener entre 2 a 1000 caracteres")
    private String descripcion;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "ERROR: campo debe ser un número positivo")
    @Size(min = 2, max = 512, message = "ERROR: campo debe contener entre 2 a 512 caracteres")
    private Long peso;

}