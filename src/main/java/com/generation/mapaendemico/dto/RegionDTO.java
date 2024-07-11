package com.generation.mapaendemico.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
public class RegionDTO {
    @Size(min = 2, max = 100, message = "El nombre debe tener mínimo 2 caracteres y máximo 50")
    @Pattern(regexp ="^[a-zA-Z]{2,20}$")
    private String nombre;

    @Size(min = 2, max = 50, message = "El nombre debe tener mínimo 2 caracteres y máximo 50")
    @Pattern(regexp ="^[a-zA-Z]{2,20}$")
    private String numero;
}
