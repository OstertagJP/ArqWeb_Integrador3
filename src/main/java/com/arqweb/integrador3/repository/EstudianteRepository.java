package com.arqweb.integrador3.repository;

import com.arqweb.integrador3.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    Estudiante findByLibretaUniversitaria(String libretaUniversitaria);

    List<Estudiante> findByGenero(String genero);



}