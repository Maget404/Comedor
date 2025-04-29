package com.example.Comedor.mapper;

import com.example.Comedor.dto.AdministradoresDTO;
import com.example.Comedor.entity.Administradores;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdministradoresMapper {
    Administradores toEntity(AdministradoresDTO dto);
    AdministradoresDTO toDto(Administradores entity);
}
