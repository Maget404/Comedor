package com.example.Comedor.mapper;

import com.example.Comedor.dto.AlumnosDTO;
import com.example.Comedor.entity.Alumnos;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AlumnosMapper {

    Alumnos toEntity(AlumnosDTO alumnosDTO);
    AlumnosDTO toDto(Alumnos alumnos);
}
