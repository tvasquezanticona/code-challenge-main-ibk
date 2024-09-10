package com.example.codechallenge.controller;

import com.example.codechallenge.model.entity.ConversionHistory;
import com.example.codechallenge.service.ConversionService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

@RestController
@RequestMapping(path = "${application.api.path}")
public class ConversionController {

        @Autowired
        private ConversionService conversionService;

        @Autowired
        private CurrencyExchangeFeignClient feignClient;

        @GetMapping
        public ConversionHistory convert(@RequestParam double amount,
                                         @RequestParam String fromCurrency,
                                         @RequestParam String toCurrency) throws JSONException {


            // Call the Feign Client to get the exchange rates
            String response = feignClient.getExchangeRates(fromCurrency);
            JSONObject json = new JSONObject(response);
            JSONObject rates = json.getJSONObject("rates");
            Double exchangeRate = rates.getDouble(toCurrency);

            //calculo de la conversion del monto
           // double convertedAmount = conversionService.convertAmount(amount, fromCurrency, toCurrency);
            Double convertedAmount = amount * exchangeRate;

            // Save the conversion to the database

            ConversionHistory conversionHistory = new ConversionHistory();
            conversionHistory.setAmount(amount);
            conversionHistory.setFromCurrency(fromCurrency);
            conversionHistory.setToCurrency(toCurrency);
            conversionHistory.setConvertedAmount(convertedAmount);
            conversionHistory.setExchangeRate(exchangeRate);
            conversionService.saveConversion(conversionHistory);

            return conversionHistory;
        }
    }
