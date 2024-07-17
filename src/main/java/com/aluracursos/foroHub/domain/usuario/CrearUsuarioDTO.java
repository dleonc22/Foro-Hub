package com.aluracursos.foroHub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CrearUsuarioDTO(
        @NotBlank
        String user,
        @NotBlank
        String password,
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotBlank @Email
        String correo

) {
}