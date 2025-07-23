package com.example.codechallenge.domain.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Data
public class ExchangeRateResponse {

    private double precioBase;
    private List<String> ajustesAplicados;
    private double primaTotal;

    }
