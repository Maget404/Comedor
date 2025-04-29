package com.example.Comedor.repository;

import com.example.Comedor.dto.AdministradoresDTO;
import com.example.Comedor.entity.Administradores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradoresRepository extends JpaRepository<Administradores,Long> {
    AdministradoresDTO save(AdministradoresDTO administradoresDTO);
    Administradores findById(long id);
}
