package com.aluracursos.foroHub.domain.respuesta.validaciones.act;

import com.aluracursos.foroHub.domain.respuesta.ActualizarRespuestaDTO;
import com.aluracursos.foroHub.domain.respuesta.Respuesta;
import com.aluracursos.foroHub.domain.respuesta.RespuestaRepository;
import com.aluracursos.foroHub.domain.topico.Estado;
import com.aluracursos.foroHub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada{

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
       if (data.solucion()){
           Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
           var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
           if (topicoResuelto.getEstado() == Estado.CLOSED){
               throw new ValidationException("Este topico ya esta solucionado.");
           }
       }
    }
}


