package com.example.Comedor.service.impl;

import com.example.Comedor.dto.PedidosDTO;
import com.example.Comedor.entity.Alumnos;
import com.example.Comedor.entity.Menu;
import com.example.Comedor.entity.Pedidos;
import com.example.Comedor.mapper.PedidosMapper;
import com.example.Comedor.repository.AlumnosRepository;
import com.example.Comedor.repository.MenuRepository;
import com.example.Comedor.repository.PedidosRepository;
import com.example.Comedor.service.PedidosService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidosServiceImpl implements PedidosService {

    private final PedidosRepository pedidosRepository;
    private final PedidosMapper pedidosMapper;
    private final AlumnosRepository alumnosRepository;
    private final MenuRepository menuRepository;

    public PedidosServiceImpl(PedidosRepository pedidosRepository, PedidosMapper pedidosMapper, AlumnosRepository alumnosRepository, MenuRepository menuRepository) {
        this.pedidosRepository = pedidosRepository;
        this.pedidosMapper = pedidosMapper;
        this.alumnosRepository = alumnosRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Pedidos> findAllPedidos() {
        return pedidosRepository.findAll();
    }

    @Override
    public Pedidos buscarPedido(long id) {
        return pedidosRepository.findById(id).get();
    }

    @Override
    public PedidosDTO nuevoPedido(PedidosDTO pedidosDTO) {
        Pedidos pedidos = new Pedidos();

        Alumnos alumnos = alumnosRepository.findById(pedidosDTO.getIdAlumno());
        pedidos.setAlumnos(alumnos);

        Menu menu = menuRepository.findById(pedidosDTO.getIdMenu());
        pedidos.setMenu(menu);

        pedidos.setCantidad(pedidosDTO.getCantidad());
        pedidos.setPrecioUnidad(menu.getPrecio());

        double total = menu.getPrecio() * pedidosDTO.getCantidad();
        total = Math.round(total * 100.0) / 100.0;
        pedidos.setTotal(total);

        pedidos.setFechaCompra(LocalDate.now());

        double actualizaSaldo = alumnos.getSaldo() - pedidos.getTotal();
        actualizaSaldo = Math.round(actualizaSaldo * 100.0) / 100.0;
        alumnos.setSaldo(actualizaSaldo);

        Pedidos saved = pedidosRepository.save(pedidos);
        return pedidosMapper.toDTO(saved);
    }

    @Override
    public PedidosDTO actualizarPedido(long id, PedidosDTO pedidosDTO) {
        Pedidos existente = pedidosRepository.findById(id).get();

        Alumnos alumno = existente.getAlumnos();
        double saldoActual = alumno.getSaldo();

        int cantidadActual = existente.getCantidad();
        int cantidadNueva = pedidosDTO.getCantidad();
        double precioUnidad = existente.getPrecioUnidad();

        double totalActual = cantidadActual * precioUnidad;
        double totalNuevo = cantidadNueva * precioUnidad;

        double diferencia = totalActual - totalNuevo;

        double nuevoSaldo = saldoActual + diferencia;
        nuevoSaldo = Math.round(nuevoSaldo * 100.0) / 100.0;
        alumno.setSaldo(nuevoSaldo);

        existente.setCantidad(cantidadNueva);
        existente.setTotal(Math.round(totalNuevo * 100.0) / 100.0);
        existente.setFechaCompra(LocalDate.now());

        pedidosRepository.save(existente);
        alumnosRepository.save(alumno);

        return pedidosMapper.toDTO(existente);
    }

    @Override
    public PedidosDTO eliminarPedido(@PathVariable long id) {
        Pedidos pedidos = pedidosRepository.findById(id).get();
        pedidosRepository.delete(pedidos);
        return pedidosMapper.toDTO(pedidos);
    }

}
