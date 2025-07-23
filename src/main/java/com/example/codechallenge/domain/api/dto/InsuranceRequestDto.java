package com.example.codechallenge.domain.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class InsuranceRequestDto {

    private String marca;
    private String modelo;
    private int anio;
    private String tipoUso;
    private int edadConductor;

}
