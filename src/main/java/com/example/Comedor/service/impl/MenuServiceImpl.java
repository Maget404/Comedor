package com.example.Comedor.service.impl;

import com.example.Comedor.dto.MenuDTO;
import com.example.Comedor.entity.Administradores;
import com.example.Comedor.entity.Menu;
import com.example.Comedor.mapper.MenuMapper;
import com.example.Comedor.repository.AdministradoresRepository;
import com.example.Comedor.repository.MenuRepository;
import com.example.Comedor.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;
    private final AdministradoresRepository administradoresRepository;

    public MenuServiceImpl(MenuRepository menuRepository, MenuMapper menuMapper, AdministradoresRepository administradoresRepository) {
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper;
        this.administradoresRepository = administradoresRepository;
    }

    @Override
    public List<Menu> findAllMenu() {
        return menuRepository.findAll();
    }

    @Override
    public Menu obtenerMenuId(long id) {
        return menuRepository.findById(id);
    }

    @Override
    public MenuDTO crearMenu(MenuDTO menuDTO) {
        Menu menu = menuMapper.toEntity(menuDTO);
        Administradores administrador = administradoresRepository.findById(menuDTO.getIdAdministrador());
        menu.setAdministradores(administrador);
        Menu saved = menuRepository.save(menu);
        return menuMapper.toDto(saved);
    }

    @Override
    public MenuDTO actualizarMenu(long id, MenuDTO menuDTO) {
        Menu existente = menuRepository.findById(id);
        Menu actualizado = menuMapper.toEntity(menuDTO);
        actualizado.setId(id);
        actualizado.setAdministradores(administradoresRepository.findById(menuDTO.getIdAdministrador()));
        Menu saved = menuRepository.save(actualizado);

        return menuMapper.toDto(saved);
    }

    @Override
    public MenuDTO borrarMenu(long id) {
        Menu existente = menuRepository.findById(id);
        menuRepository.deleteById(id);
        return menuMapper.toDto(existente);
    }

}
