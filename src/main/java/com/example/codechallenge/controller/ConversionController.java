package com.example.codechallenge.controller;

import com.example.codechallenge.model.entity.ConversionHistory;
import com.example.codechallenge.repository.ConversionHistoryRepository;
import com.example.codechallenge.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${application.api.path}")
public class ConversionController {

        @Autowired
        private ConversionService conversionService;

        @Autowired
        private ConversionHistoryRepository conversionHistoryRepository;

        @PostMapping
        public ConversionHistory convert(@RequestParam double amount,
                                         @RequestParam String fromCurrency,
                                         @RequestParam String toCurrency) {

            double convertedAmount = conversionService.convertAmount(amount, fromCurrency, toCurrency);

            ConversionHistory history = new ConversionHistory();
            history.setAmount(amount);
            history.setConvertedAmount(convertedAmount);
            history.setFromCurrency(fromCurrency);
            history.setToCurrency(toCurrency);
            history.setExchangeRate(convertedAmount / amount);

            return conversionHistoryRepository.save(history);
        }
    }
