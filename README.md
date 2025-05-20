
# Ejercicio Integrador 3 - Spring Boot + JPA + Hibernate

Este proyecto implementa funcionalidades que interactúan con una base de datos relacional utilizando Spring Boot, JPA y Hibernate. Permite la gestión de entidades como Estudiantes, Carreras y su relación, con carga desde archivos CSV, persistencia, y consultas específicas.

## 👥 Integrantes
- Pérez, Juan
- González, María
- López, Ana
- Torres, Martín

## 📈 Funcionalidades principales
- Carga de datos desde archivos CSV a la base de datos.
- CRUD completo para Estudiante, Carrera y su relación (Inscripción).
- Consultas personalizadas con JPQL a través de Spring Data JPA.
- Generación de reportes estadísticos por carrera y año.
- Arquitectura en capas con Spring Boot: Controller, Service, Repository, Domain y Utils.

## 🗂️ Estructura del Proyecto
```
src
└── main
    └── java
        └── com.arqweb.integrador3
            ├── controller
            ├── dto
            ├── entity
            ├── repository
            ├── service
            ├── utils
            └── Integrador3Application.java
```

## 📁 Recursos
CSVs ubicados en: `src/main/resources/csv/`
- estudiantes.csv
- carreras.csv
- inscripciones.csv

## ✅ Requisitos
- Java 11+
- Maven
- Spring Boot
- Spring Data JPA
- Hibernate
- OpenCSV
- MySQL

## 🔌 Endpoints REST

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/estudiantes` | Retorna todos los estudiantes. |
| GET | `/api/estudiantes/lu/{lu}` | Busca un estudiante por número de LU. |
| GET | `/api/estudiantes/genero/{genero}` | Devuelve estudiantes de un determinado género. |
| GET | `/api/estudiantes/orderBy/apellido` | Devuelve todos los estudiantes ordenados por apellido. |
| POST | `/api/estudiantes` | Dar de alta un nuevo estudiante. |
| POST | `/api/carreras` | Dar de alta una nueva carrera. |
| GET | `/api/carreras` | Obtener todas las carreras con cantidad de estudiantes inscriptos. |
| POST | `/api/inscripciones` | Matricular estudiante a una carrera. |
| GET | `/api/carreras/estudiantes/reporte` | Generar reporte con cantidad de inscriptos y graduados por carrera y año. |

## ⚙️ Configuración y Ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/tuusuario/integrador3.git
```

### 2. Crear la base de datos MySQL
```sql
CREATE DATABASE integrador3 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configurar `application.properties`
Ubicado en `src/main/resources/application.properties`, incluir:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/integrador3
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

### 4. Ejecutar la aplicación
```bash
./mvnw spring-boot:run
```

## 🔄 Importar colección Postman
Puedes importar la colección `integrador3.postman_collection.json` para probar los endpoints fácilmente desde Postman.

---

🚀 ¡Proyecto listo para explorar con Spring Boot, JPA y estadísticas académicas!
