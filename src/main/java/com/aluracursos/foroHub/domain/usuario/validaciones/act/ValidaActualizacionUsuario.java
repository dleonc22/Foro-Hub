package com.aluracursos.foroHub.domain.usuario.validaciones.act;

import com.aluracursos.foroHub.domain.usuario.ActualizarUsuarioDTO;
import com.aluracursos.foroHub.domain.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaActualizacionUsuario implements ValidarActualizarUsuario{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(ActualizarUsuarioDTO data) {
        if(data.correo() != null){
            var emailDuplicado = repository.findByEmail(data.correo());
            if(emailDuplicado != null){
                throw new ValidationException("Este email ya esta en uso");
            }
        }
    }
}

