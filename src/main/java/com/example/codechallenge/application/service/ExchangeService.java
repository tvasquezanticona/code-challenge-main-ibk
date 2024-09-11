package com.example.codechallenge.application.service;

import com.example.codechallenge.domain.model.Exchange;
import com.example.codechallenge.domain.port.ExchangeRatePort;
import com.example.codechallenge.domain.port.ExchangeRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    private final ExchangeRatePort exchangeRatePort;
    private final ExchangeRepositoryPort exchangeRepositoryPort;

    public ExchangeService(ExchangeRatePort exchangeRatePort, ExchangeRepositoryPort exchangeRepositoryPort) {
        this.exchangeRatePort = exchangeRatePort;
        this.exchangeRepositoryPort = exchangeRepositoryPort;
    }

    public Exchange convert(double amount, String sourceCurrency, String targetCurrency) {
        double rate = exchangeRatePort.getExchangeRate(sourceCurrency, targetCurrency);
        double convertedAmount = amount * rate;
        Exchange exchange = new Exchange(amount, convertedAmount, sourceCurrency, targetCurrency, rate);
        return exchangeRepositoryPort.save(exchange);
    }
}
