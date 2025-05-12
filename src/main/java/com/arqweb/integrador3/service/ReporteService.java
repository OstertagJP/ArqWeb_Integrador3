package com.arqweb.integrador3.service;


import com.arqweb.integrador3.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private CarreraRepository carreraRepository;

    public List<DTO.ReporteCarreraDTO> generarReporteCarreras() {
        return carreraRepository.generarReporteCarreras();
    }
}
