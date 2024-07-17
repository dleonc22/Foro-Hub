package com.aluracursos.foroHub.domain.usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usuarios")
@Entity(name="Usuario")
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
    private String password;

    @Enumerated(EnumType.STRING)
    private String nombre;
    private Perfil perfil;
    private String apellido;
    private String correo;
    private Boolean enabled;

    public Usuario(CrearUsuarioDTO crearUsuarioDTO, String hashedPassword) {
        this.user = crearUsuarioDTO.user();
        this.password = hashedPassword;
        this.perfil = getPerfil();
        this.nombre = capitalizado(crearUsuarioDTO.nombre());
        this.apellido = capitalizado(crearUsuarioDTO.apellido());
        this.correo = crearUsuarioDTO.correo();
        this.enabled = true;
    }

    public void actualizarUsuarioConPassword(ActualizarUsuarioDTO actualizarUsuarioDTO, String hashedPassword) {
        if (actualizarUsuarioDTO.password() != null){
            this.password = hashedPassword;
        }
        if (actualizarUsuarioDTO.perfil() != null){
            this.perfil = actualizarUsuarioDTO.perfil();
        }
        if (actualizarUsuarioDTO.nombre() != null){
            this.nombre = capitalizado(actualizarUsuarioDTO.nombre());
        }
        if (actualizarUsuarioDTO.apellido() != null){
            this.apellido = capitalizado(actualizarUsuarioDTO.apellido());
        }
        if (actualizarUsuarioDTO.correo() != null){
            this.correo = actualizarUsuarioDTO.correo();
        }
        if (actualizarUsuarioDTO.enabled() != null){
            this.enabled = actualizarUsuarioDTO.enabled();
        }
    }


    public void actualizarUsuario(ActualizarUsuarioDTO actualizarUsuarioDTO) {
        if (actualizarUsuarioDTO.perfil() != null){
            this.perfil = actualizarUsuarioDTO.perfil();
        }
        if (actualizarUsuarioDTO.nombre() != null){
            this.nombre = capitalizado(actualizarUsuarioDTO.nombre());
        }
        if (actualizarUsuarioDTO.apellido() != null){
            this.apellido = capitalizado(actualizarUsuarioDTO.apellido());
        }
        if (actualizarUsuarioDTO.correo() != null){
            this.correo = actualizarUsuarioDTO.correo();
        }
        if (actualizarUsuarioDTO.enabled() != null){
            this.enabled = actualizarUsuarioDTO.enabled();
        }
    }

    public void eliminarUsuario(){
        this.enabled = false;
    }

    private String capitalizado(String string) {
        return string.substring(0,1).toUpperCase()+string.substring(1).toLowerCase();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}