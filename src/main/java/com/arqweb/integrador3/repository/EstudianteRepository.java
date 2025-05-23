package com.arqweb.integrador3.repository;

import com.arqweb.integrador3.entity.Carrera;
import com.arqweb.integrador3.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Optional<Estudiante> findByLibretaUniversitaria(Long libretaUniversitaria);

    List<Estudiante> findByGenero(String genero);

    @Query("SELECT i.estudiante FROM Inscripcion i " +
            "WHERE i.carrera = :carrera AND i.estudiante.ciudad = :ciudad")
    List<Estudiante> buscarPorCarreraYCiudad(Carrera carrera, String ciudad);


    @Query("SELECT i.estudiante FROM Inscripcion i WHERE i.carrera = :carrera AND i.estudiante.ciudad = :ciudad")
    List<Estudiante> buscarEstudiantesPorCarreraYCiudad(Carrera carrera, String ciudad);

}
