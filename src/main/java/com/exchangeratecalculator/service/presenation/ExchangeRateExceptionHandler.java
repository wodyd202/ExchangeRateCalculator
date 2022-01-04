package com.exchangeratecalculator.service.presenation;

import com.exchangeratecalculator.service.domain.FaildExchangeRateRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExchangeRateExceptionHandler {
    @ExceptionHandler(FaildExchangeRateRequestException.class)
    public ResponseEntity<String> error(FaildExchangeRateRequestException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<List<String>> error(InvalidRequestException e){
        return ResponseEntity.badRequest().body(e.getAllErrors());
    }
}
