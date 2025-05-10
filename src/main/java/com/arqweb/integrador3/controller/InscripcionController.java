package com.arqweb.integrador3.controller;

import com.arqweb.integrador3.entity.Carrera;
import com.arqweb.integrador3.entity.Estudiante;
import com.arqweb.integrador3.entity.Inscripcion;
import com.arqweb.integrador3.service.CarreraService;
import com.arqweb.integrador3.service.EstudianteService;
import com.arqweb.integrador3.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CarreraService carreraService;

    // b) Matricular estudiante en carrera
    @PostMapping
    public Inscripcion matricular(@RequestParam int idEstudiante,
                                  @RequestParam int idCarrera,
                                  @RequestParam int anio) {

        Estudiante estudiante = estudianteService.buscarPorId(idEstudiante);
        Carrera carrera = carreraService.buscarCarreraPorId(idCarrera);

        return inscripcionService.matricularEstudiante(estudiante, carrera, anio);
    }
}
