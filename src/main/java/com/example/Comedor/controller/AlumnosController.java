package com.example.Comedor.controller;

import com.example.Comedor.dto.AlumnosDTO;
import com.example.Comedor.entity.Alumnos;
import com.example.Comedor.service.AlumnosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

    private final AlumnosService alumnosService;

    public AlumnosController(AlumnosService alumnosService) {
        this.alumnosService = alumnosService;
    }

    @GetMapping("/obtener")
    public List<Alumnos> obtenerAlumnos() {
        return alumnosService.findAllAlumnos();
    }

    @GetMapping("/obtener/{id}")
    public Alumnos obtenerAlumnobyId(@PathVariable Long id) {
        return alumnosService.obtenerAlumnobyId(id);
    }

    @PostMapping("/nuevo")
    public AlumnosDTO crearAlumno(@RequestBody AlumnosDTO alumnosDTO) {
        return alumnosService.crearAlumno(alumnosDTO);
    }

    @PutMapping("/actualizar/{id}")
    public AlumnosDTO actualizarAlumno(@PathVariable Long id, @RequestBody AlumnosDTO alumnosDTO) {
        return alumnosService.actualizarAlumno(id, alumnosDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public AlumnosDTO borrarAlumno(@PathVariable Long id) {
        return alumnosService.borrarAlumno(id);
    }
}
