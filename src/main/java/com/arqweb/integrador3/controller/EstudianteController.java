package com.arqweb.integrador3.controller;

import com.arqweb.integrador3.entity.Estudiante;
import com.arqweb.integrador3.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // a) Alta de estudiante
    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.altaEstudiante(estudiante);
    }

    // c) Obtener todos los estudiantes, con ordenamiento
    @GetMapping
    public List<Estudiante> obtenerEstudiantes(@RequestParam(defaultValue = "asc") String orden) {
        return estudianteService.listarEstudiantes(orden);
    }

    // d) Buscar por número de libreta
    @GetMapping("/libreta/{numero}")
    public Estudiante obtenerPorLibreta(@PathVariable String numero) {
        return estudianteService.buscarPorLibreta(numero);
    }

    // e) Buscar por género
    @GetMapping("/genero/{genero}")
    public List<Estudiante> obtenerPorGenero(@PathVariable String genero) {
        return estudianteService.buscarPorGenero(genero);
    }

    // g) Estudiantes por carrera y ciudad
    @GetMapping("/carrera/{idCarrera}/ciudad/{ciudad}")
    public List<Estudiante> estudiantesPorCarreraYCiudad(@PathVariable int idCarrera, @PathVariable String ciudad) {
        return estudianteService.buscarPorCarreraYCiudad(idCarrera, ciudad);
    }
}
