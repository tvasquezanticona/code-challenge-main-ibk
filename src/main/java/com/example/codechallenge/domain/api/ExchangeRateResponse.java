package com.example.codechallenge.domain.api;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Data
public class ExchangeRateResponse {


        private String base;
        private Map<String, Double> rates;

    }
