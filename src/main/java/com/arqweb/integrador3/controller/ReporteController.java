package com.arqweb.integrador3.controller;

import com.arqweb.integrador3.dto.ReporteCarreraDTO;
import com.arqweb.integrador3.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // f) Carreras con cantidad de inscriptos, ordenadas
    @GetMapping("/carreras")
    public List<ReporteCarreraDTO> carrerasConInscriptos() {
        return reporteService.generarReporteCarreras();
    }
}
