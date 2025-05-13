package com.arqweb.integrador3.service;


import com.arqweb.integrador3.dto.CarreraDTO;
import com.arqweb.integrador3.dto.ReporteCarreraDTO;
import com.arqweb.integrador3.entity.Carrera;
import com.arqweb.integrador3.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public Carrera crearCarrera(Carrera carrera){
        return carreraRepository.save(carrera);
    }

    public List<Carrera> obtenerTodasCarreras(){
        return carreraRepository.findAll();
    }

    public Carrera buscarCarreraPorId(int id) {
        return carreraRepository.findById((long) id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrera no encontrada"));
    }

    public List<CarreraDTO>obtenerCarrerasOrdenadasPorCantidadDeInscriptos(){
        return carreraRepository.obtenerCarrerasConCantidadDeInscriptos();
    }

    public List<ReporteCarreraDTO> generarReporteCarreras(){
        return carreraRepository.generarReporteCarreras();
    }
}
