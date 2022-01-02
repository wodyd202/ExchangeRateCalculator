package com.exchangeratecalculator.service.application;

import lombok.Data;

@Data
public class ExchangeRateRequestDTO {
    private String currencies = "";

    public ExchangeRateRequestDTO(String currencies) {
        this.currencies = currencies;
    }
}
