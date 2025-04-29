package com.example.Comedor.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AdministradoresDTO {
    private Long id;
    private String usuario;
    private String puesto;

    @JsonIgnore
    private String password;
}
