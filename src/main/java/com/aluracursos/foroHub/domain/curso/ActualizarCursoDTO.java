package com.aluracursos.foroHub.domain.curso;

public record ActualizarCursoDTO(
        String nombre,
        Categoria categoria,
        Boolean activo
) {
}
