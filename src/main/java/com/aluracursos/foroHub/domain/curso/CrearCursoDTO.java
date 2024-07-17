package com.aluracursos.foroHub.domain.curso;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public record CrearCursoDTO(
        @NotBlank
        String nombre,
        @NotNull
        Categoria categoria
) {
}
