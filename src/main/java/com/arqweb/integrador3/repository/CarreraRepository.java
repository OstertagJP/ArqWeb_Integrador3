package com.arqweb.integrador3.repository;

import com.arqweb.integrador3.dto.ReporteCarreraParcialDTO;
import com.arqweb.integrador3.entity.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.arqweb.integrador3.dto.CarreraDTO;

import java.util.List;

import static org.hibernate.grammars.hql.HqlParser.AS;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    @Query("SELECT new com.arqweb.integrador3.dto.CarreraDTO(" +
            "c.idCarrera, c.carrera, COUNT(i), c.duracion) " +
            "FROM Inscripcion i JOIN i.carrera c " +
            "GROUP BY c.idCarrera, c.carrera, c.duracion " +
            "ORDER BY COUNT(i) DESC")
    List<CarreraDTO> obtenerCarrerasConCantidadDeInscriptos();

    @Query("SELECT new com.arqweb.integrador3.dto.ReporteCarreraParcialDTO(" +
            "c.carrera, " +
            "CAST(FUNCTION('year', i.inscripcion) AS integer), " +
            "COUNT(i), " +
            "SUM(CASE WHEN i.graduacion IS NOT NULL THEN 1 ELSE 0 END)) " +
            "FROM Inscripcion i JOIN i.carrera c " +
            "GROUP BY c.carrera, FUNCTION('year', i.inscripcion) " +
            "ORDER BY c.carrera ASC, FUNCTION('year', i.inscripcion) ASC")
    List<ReporteCarreraParcialDTO> generarReporteCarreras();


}
