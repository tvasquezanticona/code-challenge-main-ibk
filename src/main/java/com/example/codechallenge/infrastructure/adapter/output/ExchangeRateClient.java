package com.example.codechallenge.infrastructure.adapter.output;

import com.example.codechallenge.domain.port.ExchangeRatePort;
import com.example.codechallenge.domain.port.ExchangeRepositoryPort;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "exchangeRateClient", url = "https://open.er-api.com/v6/latest")
public interface ExchangeRateClient extends ExchangeRatePort {

    @GetMapping("/{currency}")
    Map<String, Object> getRates(@PathVariable("currency") String currency);

    @Override
    default double getExchangeRate(String sourceCurrency, String targetCurrency) {
        Map<String, Object> ratesResponse = getRates(sourceCurrency);
        Map<String, Double> rates = (Map<String, Double>) ratesResponse.get("rates");
        return rates.get(targetCurrency);
    }
}
