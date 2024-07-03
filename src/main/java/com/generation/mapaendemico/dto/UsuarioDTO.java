package com.generation.mapaendemico.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UsuarioDTO {
    @NotEmpty
    @Size(min = 2, max = 50)
    @Pattern(regexp ="^[a-zA-Z]{2,20}$")
    private String nombre;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String password;

    @NotEmpty
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    @Size(min = 2, max = 50)
    private String correo;

}
