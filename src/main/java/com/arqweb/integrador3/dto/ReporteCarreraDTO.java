package com.arqweb.integrador3.dto;

import java.io.Serializable;
import java.util.List;

public class ReporteCarreraDTO implements Serializable {
    private String id;  // Cambiado a String para coincidir con el id de la entidad
    private String nombre;
    private List<EstadisticasPorAnioDTO> estadisticasPorAnio;

    public ReporteCarreraDTO() { }

    public ReporteCarreraDTO(String id, String nombre, List<EstadisticasPorAnioDTO> estadisticasPorAnio) {
        this.id = id;
        this.nombre = nombre;
        this.estadisticasPorAnio = estadisticasPorAnio;
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

    public List<EstadisticasPorAnioDTO> getEstadisticasPorAnio() {
        return estadisticasPorAnio;
    }

    public void setEstadisticasPorAnio(List<EstadisticasPorAnioDTO> estadisticasPorAnio) {
        this.estadisticasPorAnio = estadisticasPorAnio;
    }

    @Override
    public String toString() {
        return String.format("Reporte Carrera:\n" +
                        "---------------------\n" +
                        "Nombre: %s\n" +
                        "Estadísticas por Año: %s\n",
                nombre, estadisticasPorAnio);
    }
}
