package com.example.codechallenge.service.impl;

import com.example.codechallenge.model.entity.ConversionHistory;
import com.example.codechallenge.repository.ConversionHistoryRepository;
import com.example.codechallenge.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

        @Autowired
        private ConversionHistoryRepository repository;



//        public double convertAmount(double amount, String fromCurrency, String toCurrency) {
//            ExchangeRateResponse response = exchangeRateClient.getExchangeRates(fromCurrency);
//            Double rate = response.getRates().get(toCurrency);
//            if (rate == null) {
//                throw new RuntimeException("Currency not supported");
//            }
//            return amount * rate;
//        }



    public ConversionHistory saveConversion(ConversionHistory conversion) {
        return repository.save(conversion);
    }
}



