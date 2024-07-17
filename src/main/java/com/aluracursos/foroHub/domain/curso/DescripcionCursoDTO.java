package com.aluracursos.foroHub.domain.curso;

public record DescripcionCursoDTO(
        Long id,
        String nombre,
        Categoria categoria,
        Boolean activo
) {
    public DescripcionCursoDTO(Curso curso) {
        this(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria(),
                curso.getActivo()
        );
    }
}
