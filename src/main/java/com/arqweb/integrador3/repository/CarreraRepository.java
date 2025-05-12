package com.arqweb.integrador3.repository;

import com.arqweb.integrador3.entity.Carrera;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

}
