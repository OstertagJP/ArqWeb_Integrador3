
# Ejercicio Integrador 3 - Spring Boot + JPA + Hibernate

Este proyecto implementa funcionalidades que interactúan con una base de datos relacional utilizando Spring Boot, JPA y Hibernate. Permite la gestión de entidades como Estudiantes, Carreras y su relación, con carga desde archivos CSV, persistencia, y consultas específicas.

## 👥 Integrantes
- Gadea Katia
- Ostertag Juan Pablo
- Silva German
- Ibauza Matias

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

Puedes importar la colección `integrador3.postman_collection.json` para probar los endpoints fácilmente desde Postman.

Algunos ejemplos:

🅳 Obtener estudiantes filtrados por género
GET /estudiantes/genero/{genero}
Ejemplo: /estudiantes/genero/M (ver como estan cargados)
🅷 Reporte de carreras con inscriptos y graduados por año
GET /reportes/carreras



## ⚙️ Configuración y Ejecución

### 1. Clonar el repositorio
```bash
git clone https://github.com/OstertagJP/ArqWeb_Integrador3
```

### 2. Crear la base de datos MySQL
```sql
CREATE DATABASE integrador3 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configurar `application.properties`
Ubicado en `src/main/resources/application.properties`, incluir:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/integrador3
spring.datasource.username=root
spring.datasource.password=
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
