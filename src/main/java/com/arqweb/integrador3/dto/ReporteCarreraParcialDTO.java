package com.arqweb.integrador3.dto;

public class ReporteCarreraParcialDTO {
    private String carrera;
    private Integer anio;
    private Long inscriptos;
    private Long graduados;

    // Constructor principal
    public ReporteCarreraParcialDTO(String carrera, Integer anio, Long inscriptos, Long graduados) {
        this.carrera = carrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.graduados = graduados;
    }

    // Constructor adicional con tipos primitivos para evitar error en consultas JPQL
    public ReporteCarreraParcialDTO(String carrera, int anio, long inscriptos, long graduados) {
        this(carrera, Integer.valueOf(anio), Long.valueOf(inscriptos), Long.valueOf(graduados));
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Long getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(Long inscriptos) {
        this.inscriptos = inscriptos;
    }

    public Long getGraduados() {
        return graduados;
    }

    public void setGraduados(Long graduados) {
        this.graduados = graduados;
    }
}
