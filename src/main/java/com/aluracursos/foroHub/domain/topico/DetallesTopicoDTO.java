package com.aluracursos.foroHub.domain.topico;

import com.aluracursos.foroHub.domain.curso.Categoria;

import java.time.LocalDateTime;

public record DetallesTopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        LocalDateTime ultimaActualizacion,
        Estado estado,
        String usuario,
        String curso,
        Categoria categoriaCurso

) {

    public DetallesTopicoDTO(Topico topico) {
        this(topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getFechaCreacion(),
            topico.getUltimaActualizacion(),
            topico.getEstado(),
            topico.getUsuario().getUsername(),
            topico.getCurso().getNombre(),
            topico.getCurso().getCategoria()
                );
    }
}
