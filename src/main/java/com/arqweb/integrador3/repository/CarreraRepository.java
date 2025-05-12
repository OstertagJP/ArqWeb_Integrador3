package com.arqweb.integrador3.repository;

import com.arqweb.integrador3.entity.Carrera;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    @Query("SELECT new com.arqweb.integrador3.dto.CarreraDTO(c.nombre, COUNT(i)) " +
            "FROM Inscripcion i JOIN i.carrera c " +
            "GROUP BY c.nombre " +
            "ORDER BY COUNT(i) DESC")
    List<DTO.CarreraDTO> obtenerCarrerasConCantidadDeInscriptos();

    @Query("SELECT new com.arqweb.integrador3.dto.ReporteCarreraDTO(" +
            "c.nombre, " +
            "YEAR(i.inscripcion), " +
            "COUNT(i), " +
            "SUM(CASE WHEN i.graduacion IS NOT NULL THEN 1 ELSE 0 END)) " +
            "FROM Inscripcion i JOIN i.carrera c " +
            "GROUP BY c.nombre, YEAR(i.inscripcion) " +
            "ORDER BY c.nombre ASC, YEAR(i.inscripcion) ASC")
    List<DTO.ReporteCarreraDTO> generarReporteCarreras();
}
