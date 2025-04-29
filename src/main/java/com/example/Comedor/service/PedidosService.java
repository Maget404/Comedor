package com.example.Comedor.service;

import com.example.Comedor.dto.PedidosDTO;
import com.example.Comedor.entity.Pedidos;

import java.util.List;

public interface PedidosService {
    PedidosDTO nuevoPedido(PedidosDTO pedidosDTO);
    List<Pedidos> findAllPedidos();
    Pedidos buscarPedido(long id);
    PedidosDTO eliminarPedido(long id);
    PedidosDTO actualizarPedido(long id, PedidosDTO pedidosDTO);
}
