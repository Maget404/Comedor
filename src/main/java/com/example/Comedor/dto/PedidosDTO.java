package com.example.Comedor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class PedidosDTO {
    private long id;
    private Integer cantidad;
    private Double precioUnidad;
    private Double total;
    private LocalDate fechaCompra;
    private long idAlumno;
    private long idMenu;
}
