package com.example.Comedor.controller;

import com.example.Comedor.dto.PedidosDTO;
import com.example.Comedor.entity.Pedidos;
import com.example.Comedor.service.PedidosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private final PedidosService pedidosService;

    public PedidosController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @GetMapping("/obtener")
    public List<Pedidos> findAllPedidos() {
        return pedidosService.findAllPedidos();
    }

    @GetMapping("/obtener/{id}")
    public Pedidos buscarPedido(@PathVariable long id) {
        return pedidosService.buscarPedido(id);
    }

    @PostMapping("/nuevo")
    public PedidosDTO nuevoPedido(@RequestBody PedidosDTO pedidosDTO) {
        return pedidosService.nuevoPedido(pedidosDTO);
    }

    @PutMapping("/actualizar/{id}")
    public PedidosDTO actualizarPedido(@PathVariable long id, @RequestBody PedidosDTO pedidosDTO) {
        return pedidosService.actualizarPedido(id, pedidosDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public PedidosDTO eliminarPedido(@PathVariable long id) {
        return pedidosService.eliminarPedido(id);
    }
}
