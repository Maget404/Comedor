package com.example.Comedor.mapper;


import com.example.Comedor.dto.PedidosDTO;
import com.example.Comedor.entity.Pedidos;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PedidosMapper {

    Pedidos toEntity(PedidosDTO pedidosDTO);
    PedidosDTO toDTO(Pedidos pedidos);
}
