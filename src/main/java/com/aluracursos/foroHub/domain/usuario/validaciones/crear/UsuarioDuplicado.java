package com.aluracursos.foroHub.domain.usuario.validaciones.crear;


import com.aluracursos.foroHub.domain.usuario.CrearUsuarioDTO;
import com.aluracursos.foroHub.domain.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDuplicado implements ValidarCrearUsuario{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearUsuarioDTO data) {
        var usuarioDuplicado = repository.findByUsername(data.user());
        if(usuarioDuplicado != null){
            throw new ValidationException("Este usuario ya existe.");
        }

        var emailDuplicado = repository.findByEmail(data.correo());
        if(emailDuplicado != null){
            throw new ValidationException("Este email ya existe.");
        }
    }
}

