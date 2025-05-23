package com.arqweb.integrador3.dto;

import java.io.Serializable;

public class EstudianteCarreraDTO implements Serializable {
    private Long idEstudiante;
    private String idCarrera;  // Cambiado a String para coincidir con la entidad Carrera
    private int anioInscripcion;
    private boolean graduado;

    public EstudianteCarreraDTO() { }

    public EstudianteCarreraDTO(Long idEstudiante, String idCarrera, int anioInscripcion, boolean graduado) {
        this.idEstudiante = idEstudiante;
        this.idCarrera = idCarrera;
        this.anioInscripcion = anioInscripcion;
        this.graduado = graduado;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getAnioInscripcion() {
        return anioInscripcion;
    }

    public void setAnioInscripcion(int anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    @Override
    public String toString() {
        return "EstudianteCarreraDTO{" +
                "idEstudiante=" + idEstudiante +
                ", idCarrera='" + idCarrera + '\'' +
                ", anioInscripcion=" + anioInscripcion +
                ", graduado=" + graduado +
                '}';
    }
}
