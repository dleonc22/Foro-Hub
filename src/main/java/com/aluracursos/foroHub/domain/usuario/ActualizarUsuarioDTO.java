package com.aluracursos.foroHub.domain.usuario;

public record ActualizarUsuarioDTO(

        String password,
        Perfil perfil,
        String nombre,
        String apellido,
        String correo,
        Boolean enabled

) {
}