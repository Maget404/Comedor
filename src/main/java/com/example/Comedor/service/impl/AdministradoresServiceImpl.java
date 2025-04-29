package com.example.Comedor.service.impl;

import com.example.Comedor.dto.AdministradoresDTO;
import com.example.Comedor.entity.Administradores;
import com.example.Comedor.mapper.AdministradoresMapper;
import com.example.Comedor.repository.AdministradoresRepository;
import com.example.Comedor.service.AdministradoresService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdministradoresServiceImpl implements AdministradoresService {

    private final AdministradoresRepository administradoresRepository;
    private final AdministradoresMapper administradoresMapper;

    public AdministradoresServiceImpl(AdministradoresRepository administradoresRepository, AdministradoresMapper administradoresMapper) {
        this.administradoresRepository = administradoresRepository;
        this.administradoresMapper = administradoresMapper;
    }

    @Override
    public List<Administradores> findAllAdministradores() {
        return administradoresRepository.findAll();
    }

    @Override
    public Administradores obtenerAdministradores(long id) {
        return administradoresRepository.findById(id);
    }

    @Override
    public AdministradoresDTO crearAdministrador(AdministradoresDTO administradoresDTO) {
        administradoresDTO.setPassword(UUID.randomUUID().toString().substring(0, 8));

        Administradores administradores = administradoresMapper.toEntity(administradoresDTO);
        Administradores saved = administradoresRepository.save(administradores);
        return administradoresMapper.toDto(saved);
    }

    @Override
    public AdministradoresDTO actualizarAdministrador(Long Id, AdministradoresDTO administradoresDTO) {
        Administradores existente = administradoresRepository.findById(Id).get();

        Administradores actualizado = administradoresMapper.toEntity(administradoresDTO);
        actualizado.setId(existente.getId());
        actualizado.setPassword(existente.getPassword());
        Administradores saved = administradoresRepository.save(actualizado);

        return administradoresMapper.toDto(saved);
    }

    @Override
    public AdministradoresDTO eliminarAdministrador(Long Id) {
        Administradores administradores = administradoresRepository.findById(Id).get();

        administradoresRepository.delete(administradores);
        return administradoresMapper.toDto(administradores);
    }
}
