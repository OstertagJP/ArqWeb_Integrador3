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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrera;

    private String carrera;
    private Integer duracion;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    private List<Inscripcion> inscripciones;

    public String getNombre() {
        return carrera;
    }

    public void setNombre(String carrera) {
    }

    public void setCodigo(String idCarrera) {

    }
}
