package com.example.Comedor.mapper;

import com.example.Comedor.dto.MenuDTO;
import com.example.Comedor.entity.Menu;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MenuMapper {

    Menu toEntity(MenuDTO menuDTO);
    MenuDTO toDto(Menu menu);
}
