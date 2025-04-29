package com.example.Comedor.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Administradores")
public class Administradores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "usuario", nullable = false, length = 20)
    private String usuario;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "puesto", nullable = false, length = 20)
    private String puesto;
}
