package com.arqweb.integrador3.controller;


import com.arqweb.integrador3.entity.Estudiante;
import com.arqweb.integrador3.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    /**
     * a) Endpoint para dar de alta un estudiante
     */
    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.altaEstudiante(estudiante);
    }

    /**
     * c) Endpoint para recuperar todos los estudiantes con ordenamiento
     */
    @GetMapping
    public List<Estudiante> obtenerEstudiantes(@RequestParam(defaultValue = "asc") String orden) {
        return estudianteService.obtenerTodosEstudiantes(orden);
    }

    /**
     * d) Endpoint para recuperar un estudiante por su número de libreta universitaria
     */

    @GetMapping("/libreta/{numero}")
    public Estudiante obtenerPorLibreta(@PathVariable Long numero) {
        return estudianteService.findByLibretaUniversitaria(numero)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudiante no encontrado"));
    }


    /**
     * e) Endpoint para recuperar estudiantes por género
     */
    @GetMapping("/genero/{genero}")
    public List<Estudiante> obtenerPorGenero(@PathVariable String genero) {
        return estudianteService.buscarPorGenero(genero);
    }

    /**
     * g) Endpoint para recuperar estudiantes por carrera y ciudad
     */
    @GetMapping("/carrera/{idCarrera}/ciudad/{ciudad}")
    public List<Estudiante> estudiantesPorCarreraYCiudad(@PathVariable String idCarrera, @PathVariable String ciudad) {
        return estudianteService.buscarPorCarreraYCiudad(idCarrera, ciudad);
    }

}