package com.example.Comedor.controller;

import com.example.Comedor.dto.AdministradoresDTO;
import com.example.Comedor.entity.Administradores;
import com.example.Comedor.service.AdministradoresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
public class AdministradoresController {

    private final AdministradoresService administradoresService;

    public AdministradoresController(AdministradoresService administradoresService) {
        this.administradoresService = administradoresService;
    }

    @GetMapping("/obtener")
    public List<Administradores> obtenerAdministradores() {
        return administradoresService.findAllAdministradores();
    }

    @GetMapping("/obtener/{id}")
    public Administradores obtenerAdministradores(@PathVariable long id) {
        return administradoresService.obtenerAdministradores(id);
    }

    @PostMapping("/nuevo")
    public AdministradoresDTO crearAdministrador(@RequestBody AdministradoresDTO administradoresDTO) {
        return administradoresService.crearAdministrador(administradoresDTO);
    }

    @PutMapping("/actualizar/{id}")
    public AdministradoresDTO actualizarAdministrador(@RequestBody AdministradoresDTO administradoresDTO, @PathVariable Long id) {
        return administradoresService.actualizarAdministrador(id, administradoresDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public AdministradoresDTO eliminarAdministrador(@PathVariable Long id) {
        return administradoresService.eliminarAdministrador(id);
    }

}
