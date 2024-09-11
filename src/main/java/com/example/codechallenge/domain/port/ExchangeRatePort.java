package com.example.codechallenge.domain.port;

public interface ExchangeRatePort {
    double getExchangeRate(String sourceCurrency, String targetCurrency);
}
