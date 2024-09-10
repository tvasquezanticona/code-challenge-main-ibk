package com.example.codechallenge.mapper;

import com.example.codechallenge.model.api.ExchangeRateRequest;
import com.example.codechallenge.model.api.ExchangeRateResponse;
import com.example.codechallenge.model.entity.ConversionHistory;

public class ExchangeRateClientMapper {

   // private UserMapper() {}

    /**
     * Metodo que convierte el Request a la Entidad.
     * @param request {@link ExchangeRateRequest}
     * @return {@link ConversionHistory}
    **/
    public static ConversionHistory mapEntity(ExchangeRateRequest request) {
        ConversionHistory response = new ConversionHistory();
        response.setAmount(request.getAmount());
        response.setSourceCurrency(request.getSourceCurrency());
        response.setTargetCurrency(request.getTargetCurrency());
        response.setConvertedAmount(request.getConvertedAmount());
        response.setExchangeRate(request.getExchangeRate());
        return response;
    }

    /**
     * Metodo que convierte la Entidad al Response.
     * @param userEntity {@link ConversionHistory}
     * @return {@link ExchangeRateResponse}

    public static ExchangeRateResponse mapResponse(ConversionHistory conversionHistory) {
        ExchangeRateResponse response = new ExchangeRateResponse();
        response.setBase(userEntity.getId());
        response.setUsername(userEntity.getUsername());
        response.setFirstName(userEntity.getFirstName());
        response.setLastName(userEntity.getLastName());
        response.setEmail(userEntity.getEmail());
        response.setPassword(userEntity.getPassword());
        response.setPhone(userEntity.getPhone());
        response.setStatus(userEntity.getStatus());
        response.setTipoDocumento(userEntity.getTipoDocumento());
        response.setNroDocumento(userEntity.getNroDocumento());
        return response;
    }**/
}
