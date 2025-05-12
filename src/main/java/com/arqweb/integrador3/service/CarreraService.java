package servicio;


import com.arqweb.integrador3.entity.Carrera;
import com.arqweb.integrador3.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public Optional<Carrera> obtenerCarreraPorId(Long id){
        return carreraRepository.findById(id);
    }

    public List<DTO.CarreraDTO>obtenerCarrerasOrdenadasPorCantidadDeInscriptos(){
        return carreraRepository.obtenerCarrerasConCantidadDeInscriptos();
    }

    public List<DTO.ReporteCarreraDTO> generarReporteCarreras(){
        return carreraRepository.generarReporteCarreras();
    }
}
