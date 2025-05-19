package com.arqweb.integrador3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "carreras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carrera {

    @Id
    @Column(name = "id_carrera")
    private String idCarrera;

    @Column(name = "carrera")
    private String nombre;

    private Integer duracion;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    private List<Inscripcion> inscripciones;
}
