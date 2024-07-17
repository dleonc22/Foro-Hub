package com.aluracursos.foroHub.domain.usuario;

public record DatosUsuarioDTO(
        Long id,
        String user,
        Perfil perfil,
        String nombre,
        String apellido,
        String email,
        Boolean enabled
) {

    public DatosUsuarioDTO(Usuario usuario){
        this(usuario.getId(),
                usuario.getUser(),
                usuario.getPerfil(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo(),
                usuario.getEnabled()
        );
    }
}