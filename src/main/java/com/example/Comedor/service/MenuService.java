package com.example.Comedor.service;

import com.example.Comedor.dto.MenuDTO;
import com.example.Comedor.entity.Menu;

import java.util.List;

public interface MenuService {
    MenuDTO crearMenu(MenuDTO menuDTO);
    List<Menu> findAllMenu();
    Menu obtenerMenuId(long id);
    MenuDTO actualizarMenu(long id, MenuDTO menuDTO);
    MenuDTO borrarMenu(long id);
}
