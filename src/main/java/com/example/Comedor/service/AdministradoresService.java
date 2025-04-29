package com.example.Comedor.service;

import com.example.Comedor.dto.AdministradoresDTO;
import com.example.Comedor.entity.Administradores;

import java.util.List;

public interface AdministradoresService {
    AdministradoresDTO crearAdministrador(AdministradoresDTO administradoresDTO);
    List<Administradores> findAllAdministradores();
    Administradores obtenerAdministradores(long id);
    AdministradoresDTO actualizarAdministrador(Long Id, AdministradoresDTO administradoresDTO);
    AdministradoresDTO eliminarAdministrador(Long Id);
}
