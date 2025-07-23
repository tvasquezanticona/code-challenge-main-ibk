package com.example.codechallenge.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceQuote {
    private String marca;
    private String modelo;
    private int anio;
    private String tipoUso;
    private int edadConductor;


}
