package com.aluracursos.foroHub.domain.topico.validaciones.act;

import com.aluracursos.foroHub.domain.curso.CursoRepository;
import com.aluracursos.foroHub.domain.topico.ActualizarTopicoDTO;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarCursoActualizado implements ValidarTopicoActualizado{

    @Autowired
    private CursoRepository repository;

    @Override
    public void validate(ActualizarTopicoDTO data) {
        if(data.cursoId() != null){
            var ExisteCurso = repository.existsById(data.cursoId());
            if (!ExisteCurso){
                throw new ValidationException("Este curso no existe");
            }

            var cursoHabilitado = repository.findById(data.cursoId()).get().getActivo();
            if(!cursoHabilitado){
                throw new ValidationException("Este curso no esta disponible en este momento.");
            }
        }

    }
}


