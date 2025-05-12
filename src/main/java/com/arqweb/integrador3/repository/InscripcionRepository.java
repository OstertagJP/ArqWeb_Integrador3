package com.arqweb.integrador3.repository;

import com.arqweb.integrador3.entity.Carrera;
import com.arqweb.integrador3.entity.Estudiante;
import com.arqweb.integrador3.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    List<Inscripcion> findByCarrera(Carrera carrera);

    List<Inscripcion> findByCarreraAndEstudiante_Ciudad(Carrera carrera, String ciudad);
}
