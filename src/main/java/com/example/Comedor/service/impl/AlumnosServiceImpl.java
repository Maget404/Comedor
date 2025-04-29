package com.example.Comedor.service.impl;

import com.example.Comedor.dto.AlumnosDTO;
import com.example.Comedor.entity.Alumnos;
import com.example.Comedor.mapper.AlumnosMapper;
import com.example.Comedor.repository.AlumnosRepository;
import com.example.Comedor.service.AlumnosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    private final AlumnosRepository alumnosRepository;
    private final AlumnosMapper alumnosMapper;

    public AlumnosServiceImpl(AlumnosRepository alumnosRepository, AlumnosMapper
                              alumnosMapper) {
        this.alumnosRepository = alumnosRepository;
        this.alumnosMapper = alumnosMapper;
    }

    @Override
    public AlumnosDTO save(AlumnosDTO alumnosDTO) {
        Alumnos alumnos = alumnosMapper.toEntity(alumnosDTO);
        Alumnos saved = alumnosRepository.save(alumnos);
        return alumnosMapper.toDto(saved);
    }

    @Override
    public List<Alumnos> findAllAlumnos() {
        return alumnosRepository.findAll();
    }

    @Override
    public Alumnos obtenerAlumnobyId(Long id) {
        return alumnosRepository.findById(id).get();
    }

    @Override
    public AlumnosDTO crearAlumno(AlumnosDTO alumnosDTO) {
        Alumnos alumnos = alumnosMapper.toEntity(alumnosDTO);
        Alumnos saved = alumnosRepository.save(alumnos);
        return alumnosMapper.toDto(saved);
    }

    @Override
    public AlumnosDTO actualizarAlumno(Long Id, AlumnosDTO alumnosDTO) {
        Alumnos alumnos = alumnosRepository.findById(Id).get();

        Alumnos actualizado = alumnosMapper.toEntity(alumnosDTO);
        actualizado.setId(Id);
        Alumnos saved = alumnosRepository.save(actualizado);

        return alumnosMapper.toDto(saved);
    }

    @Override
    public AlumnosDTO borrarAlumno(Long id) {
        Alumnos alumnos = alumnosRepository.findById(id).get();

        alumnosRepository.delete(alumnos);
        return alumnosMapper.toDto(alumnos);
    }
}
