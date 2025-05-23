package com.arqweb.integrador3.dto;

import java.io.Serializable;

public class EstadisticasPorAnioDTO implements Serializable {
    private Integer anio;
    private int cantidadInscriptos;
    private int cantidadEgresados;

    public EstadisticasPorAnioDTO() {

    }

    public EstadisticasPorAnioDTO(Integer anio, int cantidadInscriptos, int cantidadEgresados) {
        this.anio = anio;
        this.cantidadInscriptos = cantidadInscriptos;
        this.cantidadEgresados = cantidadEgresados;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public int getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(int cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    public int getCantidadEgresados() {
        return cantidadEgresados;
    }

    public void setCantidadEgresados(int cantidadEgresados) {
        this.cantidadEgresados = cantidadEgresados;
    }

    @Override
    public String toString() {
        return String.format("Año: %d\n" +
                        "  Inscriptos: %d\n" +
                        "  Egresados: %d",
                anio, cantidadInscriptos, cantidadEgresados);
    }
}