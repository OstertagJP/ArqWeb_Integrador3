package com.arqweb.integrador3.readerCSV;

import com.arqweb.integrador3.entity.Carrera;
import com.arqweb.integrador3.entity.Estudiante;
import com.arqweb.integrador3.service.CarreraService;
import com.arqweb.integrador3.service.EstudianteService;
import com.arqweb.integrador3.service.InscripcionService;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.io.Reader;

@Component
public class DBInitializer {

    private final CarreraService carreraService;
    private final EstudianteService estudianteService;
    private final InscripcionService inscripcionService;

    @Autowired
    public DBInitializer(CarreraService carreraService,
                         EstudianteService estudianteService,
                         InscripcionService inscripcionService) {
        this.carreraService = carreraService;
        this.estudianteService = estudianteService;
        this.inscripcionService = inscripcionService;
    }

    @PostConstruct
    public void cargarDatos() {
        try {
            // Limpieza previa de datos
            inscripcionService.eliminarTodasLasInscripciones();
            estudianteService.eliminarTodosLosEstudiantes();
            carreraService.eliminarTodasLasCarreras();

            // Carga de CSV
            cargarCarreras();
            cargarEstudiantes();
            cargarInscripciones();
        } catch (Exception e) {
            System.err.println("Error al cargar los datos desde CSV: " + e.getMessage());
        }
    }

    private void cargarCarreras() throws Exception {
        try (
                Reader reader = new InputStreamReader(new ClassPathResource("carreras.csv").getInputStream());
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)
        ) {
            for (CSVRecord record : csvParser) {
                Carrera carrera = new Carrera();
                carrera.setIdCarrera(record.get("id_carrera"));
                carrera.setNombre(record.get("carrera"));
                carrera.setDuracion(Integer.parseInt(record.get("duracion")));

                carreraService.crearCarrera(carrera);
            }
        }
    }

    private void cargarEstudiantes() throws Exception {
        try (
                Reader reader = new InputStreamReader(new ClassPathResource("estudiantes.csv").getInputStream());
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)
        ) {
            for (CSVRecord record : csvParser) {
                Estudiante estudiante = new Estudiante();
                estudiante.setDni(Long.parseLong(record.get("DNI")));
                estudiante.setNombre(record.get("nombre"));
                estudiante.setApellido(record.get("apellido"));
                estudiante.setEdad(Integer.parseInt(record.get("edad")));
                estudiante.setGenero(record.get("genero"));
                estudiante.setCiudad(record.get("ciudad"));
                estudiante.setLibretaUniversitaria(Long.parseLong(record.get("LU")));
                estudianteService.altaEstudiante(estudiante);
            }
        }
    }

    private void cargarInscripciones() throws Exception {
        try (
                Reader reader = new InputStreamReader(new ClassPathResource("estudianteCarrera.csv").getInputStream());
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)
        ) {
            for (CSVRecord record : csvParser) {
                Long idEstudiante = Long.parseLong(record.get("id_estudiante"));
                Long idCarrera = Long.parseLong(record.get("id_carrera"));
                int anioInscripcion = Integer.parseInt(record.get("inscripcion"));
                boolean graduado = false;

                if (record.isMapped("graduacion")) {
                    String grad = record.get("graduacion");
                    graduado = grad != null && !grad.trim().isEmpty() && !grad.trim().equals("0");
                }

                if (estudianteService.buscarPorId(idEstudiante).isPresent()
                        && carreraService.buscarPorId(idCarrera).isPresent()) {
                    inscripcionService.matricularEstudiante(idEstudiante, idCarrera, anioInscripcion, graduado);
                } else {
                    System.err.println("⚠ No se encontró estudiante o carrera. Estudiante ID: " + idEstudiante +
                            ", Carrera ID: " + idCarrera);
                }
            }
        }
    }
}
