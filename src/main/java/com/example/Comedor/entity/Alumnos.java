package com.example.Comedor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "Alumnos")
public class Alumnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false, length = 20)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false, length = 20)
    private String apellidoMaterno;

    @Column(name = "matricula", unique = true, nullable = false, length = 10)
    private String matricula;

    @Column(name = "saldo", nullable = false)
    private double saldo;
}
