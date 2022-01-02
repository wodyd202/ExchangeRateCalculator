package com.exchangeratecalculator.infrastructure;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ExchangeRateRequesterDTO {
    private String access_key;
    private String currencies;
    private int format;

    @Builder
    public ExchangeRateRequesterDTO(String access_key, String currencies, int format) {
        this.access_key = access_key;
        this.currencies = currencies;
        this.format = format;
    }
}
