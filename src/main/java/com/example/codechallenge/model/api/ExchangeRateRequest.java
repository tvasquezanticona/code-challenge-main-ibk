package com.example.codechallenge.model.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExchangeRateRequest {

    private Long id;
    private double amount;
    private double convertedAmount;
    private String sourceCurrency;
    private String targetCurrency;
    private double exchangeRate;

}
