package com.example.codechallenge.service.impl;

import com.example.codechallenge.application.service.CalculateInsuranceUseCase;
import com.example.codechallenge.domain.InsuranceQuote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;

class UserServiceImplTest {

    private CalculateInsuranceUseCase calculateInsuranceUseCase;

    @BeforeEach
    void setUp() {
        calculateInsuranceUseCase = new CalculateInsuranceUseCase();
    }

    @Test
    void testSimulationBMW() {
        InsuranceQuote insuranceRequestDto = new InsuranceQuote();
        insuranceRequestDto.setMarca("BMW");
        insuranceRequestDto.setModelo("X5");
        insuranceRequestDto.setAnio(2020);
        insuranceRequestDto.setTipoUso("carga");
        insuranceRequestDto.setEdadConductor(51);

        calculateInsuranceUseCase.calcular(insuranceRequestDto).subscribe(result -> {
            assertEquals(500.0, result.getPrecioBase());
            assertEquals(675.0, result.getPrimaTotal());
        });
    }

    @Test
    void testSimulationToyota() {
        InsuranceQuote request = new InsuranceQuote();
        request.setMarca("Toyota");
        request.setModelo("Yaris");
        request.setAnio(2011);
        request.setTipoUso("Personal");
        request.setEdadConductor(34);

        calculateInsuranceUseCase.calcular(request).subscribe(result -> {
            assertEquals(500.0, result.getPrecioBase());
            assertEquals(500.0, result.getPrimaTotal());
        });
    }

    @Test
    void testCacheSimulation() throws InterruptedException {
        InsuranceQuote request = new InsuranceQuote();
        request.setMarca("Audi");
        request.setModelo("A4");
        request.setAnio(2020);
        request.setTipoUso("CARGA");
        request.setEdadConductor(55);

        CountDownLatch latch = new CountDownLatch(1);

        calculateInsuranceUseCase.calcular(request).subscribe(first -> {
            calculateInsuranceUseCase.calcular(request).subscribe(second -> {
                assertEquals(first.getPrimaTotal(), second.getPrimaTotal());
                assertEquals(first.getAjustesAplicados(), second.getAjustesAplicados());
                latch.countDown();
            });
        });

        latch.await(); // espera que el test termine
    }








}


