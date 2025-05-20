package com.arqweb.integrador3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    @JsonIgnore     //Esto es para que muestre uno dentro del otro, como algo recursivo infinito
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
    @JsonIgnore     //Esto es para que muestre uno dentro del otro, como algo recursivo infinito
    private Carrera carrera;

    private LocalDate inscripcion;
    private LocalDate graduacion;
    private Integer antiguedad;

    public int getAntiguedad() {
        if (inscripcion == null) return 0;
        return LocalDate.now().getYear() - inscripcion.getYear();
    }

    public boolean isGraduado() {
        return graduacion != null;
    }
}
