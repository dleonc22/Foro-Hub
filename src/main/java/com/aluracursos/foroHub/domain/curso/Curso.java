package com.aluracursos.foroHub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cursos")
@Entity(name = "Curso")
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean activo;


    public Curso(CrearCursoDTO crearCursoDTO) {
        this.nombre = crearCursoDTO.nombre();
        this.categoria = crearCursoDTO.categoria();
        this.activo = true;
    }


    public void actualizarCurso(ActualizarCursoDTO actualizarCursoDTO) {

        if(actualizarCursoDTO.nombre() != null){
            this.nombre = actualizarCursoDTO.nombre();
        }
        if (actualizarCursoDTO.categoria() != null){
            this.categoria = actualizarCursoDTO.categoria();
        }
        if (actualizarCursoDTO.activo() != null){
            this.activo = actualizarCursoDTO.activo();
        }
    }

    public void eliminarCurso(){
        this.activo = false;
    }

}
