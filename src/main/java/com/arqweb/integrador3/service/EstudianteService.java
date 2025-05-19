package com.arqweb.integrador3.service;



import java.util.List;

import com.arqweb.integrador3.entity.Carrera;
import com.arqweb.integrador3.entity.Estudiante;
import com.arqweb.integrador3.repository.CarreraRepository;
import com.arqweb.integrador3.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante altaEstudiante(Estudiante estudiante) {

        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerTodosEstudiantes(String orden) {
        Sort sort = orden.equalsIgnoreCase("desc") ? Sort.by("nombre").descending() : Sort.by("nombre").ascending();
        return estudianteRepository.findAll(sort);
    }

    public Optional<Estudiante> findByLibretaUniversitaria(Long libretaUniversitaria) {
        return estudianteRepository.findByLibretaUniversitaria(libretaUniversitaria);
    }

    public List<Estudiante> buscarPorGenero(String genero) {
        return estudianteRepository.findByGenero(genero);
    }

    @Autowired
    private CarreraRepository carreraRepository;

    public List<Estudiante> buscarPorCarreraYCiudad(int idCarrera, String ciudad) {
        Carrera carrera = carreraRepository.findById((long) idCarrera)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrera no encontrada"));

        return estudianteRepository.buscarEstudiantesPorCarreraYCiudad(carrera, ciudad);
    }

    public Estudiante buscarPorId(int id) {
        return estudianteRepository.findById((long) id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudiante no encontrado"));
    }

    public Optional<Estudiante> buscarPorId(Long id) {
        return estudianteRepository.findById(id);
    }


}
