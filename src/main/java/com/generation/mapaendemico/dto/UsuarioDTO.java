package com.generation.mapaendemico.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class UsuarioDTO {
    @NotBlank(message = "Debe ingresar un nombre")
    @Size(min = 2, max = 50, message = "El nombre debe tener mínimo 2 caracteres y máximo 50")
    @Pattern(regexp ="^[a-zA-Z]{2,20}$", message = "Debe usar cáracteres válidos")
    private String nombre;

    @NotBlank(message = "Debe ingresar una contraseña")
    @Size(min = 2, max = 50, message = "El nombre debe tener mínimo 2 caracteres y máximo 50")
    private String password;

    @NotBlank(message = "Debe ingresar un correo electrónico")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "El correo electrónico no es válido")
    @Size(min = 2, max = 50, message = "El nombre debe tener mínimo 2 caracteres y máximo 50")
    private String correo;
}
