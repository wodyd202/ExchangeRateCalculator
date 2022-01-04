package com.exchangeratecalculator.service.presenation;

import com.exchangeratecalculator.service.application.ExchangeRateRequestDTO;
import com.exchangeratecalculator.service.application.ExchangeRateService;
import com.exchangeratecalculator.service.domain.ExchangeRate;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 환율 정보 API
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/exchange-rate")
public class ExchangeRateAPI {
    private final ExchangeRateService exchangeRateService;

    @GetMapping
    public ResponseEntity<ExchangeRate> getExchangeRate(@Valid ExchangeRateRequestDTO exchangeRateRequestDTO, Errors errors){
        if(errors.hasErrors()){
            throw new InvalidRequestException(errors);
        }
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(exchangeRateRequestDTO);
        return ResponseEntity.ok(exchangeRate);
    }
}
