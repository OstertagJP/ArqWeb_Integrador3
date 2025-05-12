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
    private CarreraRepository carreraRepo;

    public Carrera crearCarrera(Carrera carrera){
        return carreraRepo.save(carrera);
    }

    public List<Carrera> obtenerTodasCarreras(){
        return carreraRepo.findAll();
    }

    public Optional<Carrera> obtenerCarreraPorId(Long id){
        return carreraRepo.findById(id);
    }

    public List<Carrera>
}
