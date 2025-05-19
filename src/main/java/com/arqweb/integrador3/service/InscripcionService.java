package com.arqweb.integrador3.service;


import com.arqweb.integrador3.entity.Carrera;
import com.arqweb.integrador3.entity.Estudiante;
import com.arqweb.integrador3.entity.Inscripcion;
import com.arqweb.integrador3.repository.CarreraRepository;
import com.arqweb.integrador3.repository.EstudianteRepository;
import com.arqweb.integrador3.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public Inscripcion matricularEstudiante(Long idEstudiante, String idCarrera, int anioInscripcion, boolean graduado) {
        Optional<Estudiante> estudainteOptional = estudianteRepository.findById(idEstudiante);
        Optional<Carrera> carreraOptional = carreraRepository.findById(idCarrera);
        if (estudainteOptional.isEmpty() || carreraOptional.isEmpty()) {
            throw new RuntimeException("Estudiante o carrera no encontrados");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudainteOptional.get());
        inscripcion.setCarrera(carreraOptional.get());
        inscripcion.setInscripcion(LocalDate.of(anioInscripcion, 1, 1));


        if (graduado) {
            inscripcion.setGraduacion(LocalDate.now()); // o podés parametrizarla
        } else {
            inscripcion.setGraduacion(null);
        }

        return inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> buscarPorCarrera(Carrera carrera){
        return inscripcionRepository.findByCarrera(carrera);
    }

    public List<Inscripcion> listarTodasLasInscripciones(){
        return inscripcionRepository.findAll();
    }

    public void eliminarTodasLasInscripciones() {
        inscripcionRepository.deleteAll();
    }

}
