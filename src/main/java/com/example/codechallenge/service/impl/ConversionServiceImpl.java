package com.example.codechallenge.service.impl;

import com.example.codechallenge.controller.ExchangeRateClient;
import com.example.codechallenge.model.api.ExchangeRateResponse;
import com.example.codechallenge.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {


        @Autowired
        private ExchangeRateClient exchangeRateClient;

        public double convertAmount(double amount, String fromCurrency, String toCurrency) {
            ExchangeRateResponse response = exchangeRateClient.getExchangeRates(fromCurrency);
            Double rate = response.getRates().get(toCurrency);
            if (rate == null) {
                throw new RuntimeException("Currency not supported");
            }
            return amount * rate;
        }
    }


