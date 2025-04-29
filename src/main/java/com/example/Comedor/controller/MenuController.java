package com.example.Comedor.controller;

import com.example.Comedor.dto.MenuDTO;
import com.example.Comedor.entity.Menu;
import com.example.Comedor.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/obtener")
    public List<Menu> obtenerMenu() {
        return menuService.findAllMenu();
    }

    @GetMapping("/obtener/{id}")
    public Menu obtenerMenuId(@PathVariable long id) {
        return menuService.obtenerMenuId(id);
    }

    @PostMapping("/nuevo")
    public MenuDTO crearMenu(@RequestBody MenuDTO menuDTO) {
        return menuService.crearMenu(menuDTO);
    }

    @PutMapping("/actualizar/{id}")
    public MenuDTO actualizarMenu(@RequestBody MenuDTO menuDTO, @PathVariable long id) {
        return menuService.actualizarMenu(id, menuDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public MenuDTO borrarMenu(@PathVariable long id) {
        return menuService.borrarMenu(id);
    }
}
