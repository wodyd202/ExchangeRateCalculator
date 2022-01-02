package com.exchangeratecalculator.infrastructure;

import com.exchangeratecalculator.config.exchangerateAPI.ExchangeRateRequestProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExchangeRateRequester_Test {
    @Autowired ExchangeRateRequester exchangeRateRequester;
    @Autowired ExchangeRateRequestProperties exchangeRateRequesterDTO;

    @Test
    @DisplayName("환율정보 요청")
    void getExchangeRate(){
        ExchangeRateResponse o = exchangeRateRequester.getExchangeRate(exchangeRateRequesterDTO);
        System.out.println(o);
    }
}
