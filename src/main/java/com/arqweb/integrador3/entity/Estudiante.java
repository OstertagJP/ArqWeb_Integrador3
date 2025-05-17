package com.arqweb.integrador3.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    @Id
    private Long dni;

    private String nombre;
    private String apellido;
    private Integer edad;
    private String genero;
    private String ciudad;
    private Long libretaUniversitaria;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripciones;
}
