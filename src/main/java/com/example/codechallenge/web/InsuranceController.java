package com.example.codechallenge.web;

import com.example.codechallenge.application.service.CalculateInsuranceUseCase;
import com.example.codechallenge.domain.InsuranceQuote;
import com.example.codechallenge.domain.model.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/simular")
public class InsuranceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceController.class);

    private final CalculateInsuranceUseCase calculateInsuranceUseCase;


    public InsuranceController(CalculateInsuranceUseCase calculateInsuranceUseCase) {
        this.calculateInsuranceUseCase = calculateInsuranceUseCase;
    }

    @PostMapping
    public Mono<Exchange> simulate(@RequestBody InsuranceQuote insuranceRequestDto){
        return calculateInsuranceUseCase.calcular(insuranceRequestDto);

    }





}
