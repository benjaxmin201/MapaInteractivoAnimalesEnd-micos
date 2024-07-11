package com.generation.mapaendemico.dto;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
public class ParqueDTO {

    @Pattern(regexp ="^[a-zA-Z]{2,50}$", message = "Campo incorrecto")
    @Size(min = 2, max = 100)
    private String nombre;

    @Pattern(regexp ="^[a-zA-Z]{2,2000}$", message = "Campo incorrecto")
    @Size(min = 2, max = 2000, message = "La extensión de descripción debe ser entre 2 a 1000 caracteres")
    private String descripcion;
}
