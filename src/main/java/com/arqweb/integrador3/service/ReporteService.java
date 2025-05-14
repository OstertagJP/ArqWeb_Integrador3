package com.arqweb.integrador3.service;

import com.arqweb.integrador3.dto.EstadisticasPorAnioDTO;
import com.arqweb.integrador3.dto.ReporteCarreraDTO;
import com.arqweb.integrador3.dto.ReporteCarreraParcialDTO;
import com.arqweb.integrador3.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReporteService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<ReporteCarreraDTO> generarReporteCarreras() {
        List<ReporteCarreraParcialDTO> parciales = carreraRepository.generarReporteCarreras();

        // Agrupamos por nombre de carrera
        Map<String, List<ReporteCarreraParcialDTO>> agrupado = parciales.stream()
                .collect(Collectors.groupingBy(ReporteCarreraParcialDTO::getCarrera));

        List<ReporteCarreraDTO> resultado = new ArrayList<>();

        for (Map.Entry<String, List<ReporteCarreraParcialDTO>> entry : agrupado.entrySet()) {
            String nombreCarrera = entry.getKey();

            List<EstadisticasPorAnioDTO> estadisticas = entry.getValue().stream()
                    .map(p -> new EstadisticasPorAnioDTO(
                            p.getAnio().intValue(),
                            p.getInscriptos().intValue(),
                            p.getGraduados().intValue()))
                    .collect(Collectors.toList());

            ReporteCarreraDTO dto = new ReporteCarreraDTO(null, nombreCarrera, estadisticas);
            resultado.add(dto);
        }

        return resultado;
    }
}
