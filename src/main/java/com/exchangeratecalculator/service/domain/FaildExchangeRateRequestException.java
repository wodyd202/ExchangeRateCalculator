package com.exchangeratecalculator.service.domain;

public class FaildExchangeRateRequestException extends RuntimeException {
    public FaildExchangeRateRequestException(String msg){
        super(msg);
    }
}
