package com.arqweb.integrador3.dto;

import java.io.Serializable;

public class CarreraDTO implements Serializable {
    private String id;
    private String nombre;
    private int cantidadInscriptos;
    private Integer duracion;

    public CarreraDTO() {
    }

    // Constructor con parámetros
    public CarreraDTO(String id, String nombre, Long cantidadInscriptos, Integer duracion) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadInscriptos = cantidadInscriptos.intValue(); // conversión
        this.duracion = duracion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(int cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    @Override
    public String toString() {
        return String.format("Carrera:\n" +
                        "---------\n" +
                        "Nombre: %s\n" +
                        "Cantidad de Inscriptos: %d",
                nombre, cantidadInscriptos);
    }
}
