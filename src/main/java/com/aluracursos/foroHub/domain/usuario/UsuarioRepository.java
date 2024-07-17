package com.aluracursos.foroHub.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByUsername(String user);
    UserDetails findByEmail(String correo);

    Page<Usuario> findAllByEnabledTrue(Pageable pageable);

    Usuario getReferenceById(Long id);

    Page<Usuario> findAll(Pageable pageable);//nueva

    Usuario getReferenceByUsername(String user);
    Boolean existsByUsername(String user);
}