package com.example.Comedor.repository;

import com.example.Comedor.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    Pedidos save(Pedidos pedidos);
}
