package com.example.Comedor.repository;

import com.example.Comedor.dto.MenuDTO;
import com.example.Comedor.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu save(Menu menu);
    Menu findById(long id);
}
