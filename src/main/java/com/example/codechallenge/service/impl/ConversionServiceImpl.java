package com.example.codechallenge.service.impl;

import com.example.codechallenge.controller.CurrencyExchangeFeignClient;
import com.example.codechallenge.model.api.ExchangeRateResponse;
import com.example.codechallenge.model.entity.ConversionHistory;
import com.example.codechallenge.repository.ConversionHistoryRepository;
import com.example.codechallenge.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

        @Autowired
        private ConversionHistoryRepository repository;

        @Autowired
        private CurrencyExchangeFeignClient exchangeFeignClient;

//        public double convertAmount(double amount, String fromCurrency, String toCurrency) {
//            ExchangeRateResponse response = exchangeRateClient.getExchangeRates(fromCurrency);
//            Double rate = response.getRates().get(toCurrency);
//            if (rate == null) {
//                throw new RuntimeException("Currency not supported");
//            }
//            return amount * rate;
//        }



//    public ConversionHistory saveConversion(ConversionHistory conversion) {
//        ExchangeRateResponse response = exchangeFeignClient.getExchangeRates(conversion.getSourceCurrency());
//        double exchangeRate = response.getRates().get(conversion.getTargetCurrency());
//        double amountWithExchange = conversion.getAmount() * exchangeRate;
//
//        ConversionHistory operation = new ConversionHistory();
//        operation.setAmount(conversion.getAmount());
//        operation.setSourceCurrency(conversion.getSourceCurrency());
//        operation.setTargetCurrency(conversion.getTargetCurrency());
//        operation.setExchangeRate(exchangeRate);
//        operation.setConvertedAmount(amountWithExchange);
//
//
//        return repository.save(conversion);
//    }

    @Override
    public ConversionHistory saveConversion(double amount, String sourceCurrency, String targetCurrency) {
        ExchangeRateResponse response = exchangeFeignClient.getExchangeRates(sourceCurrency);
        double exchangeRate = response.getRates().get(targetCurrency);
        double amountWithExchange = amount * exchangeRate;

        ConversionHistory operation = new ConversionHistory();
        operation.setAmount(amount);
        operation.setSourceCurrency(sourceCurrency);
        operation.setTargetCurrency(targetCurrency);
        operation.setExchangeRate(exchangeRate);
        operation.setConvertedAmount(amountWithExchange);


        return repository.save(operation);
    }
}



