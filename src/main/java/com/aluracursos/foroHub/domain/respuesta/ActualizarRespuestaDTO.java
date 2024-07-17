package com.aluracursos.foroHub.domain.respuesta;

public record ActualizarRespuestaDTO(
        String mensaje,
        Boolean solucion,
        Boolean borrado
) {
}
