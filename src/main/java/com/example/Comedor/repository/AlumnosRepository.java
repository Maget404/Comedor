package com.example.Comedor.repository;

import com.example.Comedor.entity.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnosRepository extends JpaRepository<Alumnos, Long> {
    Alumnos save(Alumnos alumnos);
    Alumnos findById(long id);
}
