package com.example.Comedor.service;

import com.example.Comedor.dto.AlumnosDTO;
import com.example.Comedor.entity.Alumnos;

import java.util.List;

public interface AlumnosService {
    AlumnosDTO save(AlumnosDTO alumnosDTO);
    List<Alumnos> findAllAlumnos();
    Alumnos obtenerAlumnobyId(Long id);
    AlumnosDTO crearAlumno(AlumnosDTO alumnosDTO);
    AlumnosDTO actualizarAlumno(Long Id, AlumnosDTO alumnosDTO);
    AlumnosDTO borrarAlumno(Long id);
}
