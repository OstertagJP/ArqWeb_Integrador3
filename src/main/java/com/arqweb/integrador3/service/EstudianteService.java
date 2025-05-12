package servicio;
import java.util.List;
import com.arqweb.integrador3.entity.Estudiante;
import com.arqweb.integrador3.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante altaEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerTodosEstudiantes(Sort sort){
        return estudianteRepository.findAll(sort);
    }

    public Optional<Estudiante> findByLibretaUniversitaria(Long libretaUniversitaria) {
        return estudianteRepository.findByLibretaUniversitaria(libretaUniversitaria);

    }

    public List<Estudiante> obtenerPorGenero(String genero) {
        return estudianteRepository.findByGenero(genero);
    }

    public List<Estudiante> obtenerPorCarreraYCiudad(String carrera, String ciudad) {
        return estudianteRepository.buscarPorCarreraYCiudad(carrera, ciudad);
    }
}
