package com.aluracursos.foroHub.domain.respuesta.validaciones.act;

import com.aluracursos.foroHub.domain.respuesta.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {

    public void validate(ActualizarRespuestaDTO data, Long respuestaId);

}
