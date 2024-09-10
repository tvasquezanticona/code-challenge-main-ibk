package com.example.codechallenge.controller;

import com.example.codechallenge.model.api.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "exchangeRateClient", url = "https://open.er-api.com/v6/latest/USD")
public interface ExchangeRateClient {

        @GetMapping
        ExchangeRateResponse getExchangeRates(@RequestParam("base") String baseCurrency);
    }


