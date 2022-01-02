package com.exchangeratecalculator.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ExchangeRateRequester_Test {
    @Autowired ExchangeRateRequester exchangeRateRequester;

    @Test
    @DisplayName("환율정보 요청")
    void getExchangeRate(){
        ExchangeRateRequesterDTO exchangeRateRequesterDTO = ExchangeRateRequesterDTO.builder()
                .access_key("e093e15179389fe2c1fb713fbf1ea036")
                .currencies("KRW,JPY,PHP")
                .format(1)
                .build();
        ExchangeRateResponse o = exchangeRateRequester.get(exchangeRateRequesterDTO);
    }
}
