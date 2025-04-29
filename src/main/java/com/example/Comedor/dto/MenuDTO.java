package com.example.Comedor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class MenuDTO {

    private long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private LocalDate fechaMenu;
    private long idAdministrador;
}
