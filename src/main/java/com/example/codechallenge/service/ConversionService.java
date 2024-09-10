package com.example.codechallenge.service;


import com.example.codechallenge.model.entity.ConversionHistory;

public interface ConversionService {
   // double convertAmount(double amount, String fromCurrency, String toCurrency) ;
      ConversionHistory saveConversion(ConversionHistory conversion);
}
