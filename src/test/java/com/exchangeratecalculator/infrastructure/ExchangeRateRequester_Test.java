package com.exchangeratecalculator.infrastructure;

import com.exchangeratecalculator.config.exchangerateAPI.ExchangeRateRequestProperties;
import com.exchangeratecalculator.service.domain.ExchangeRate;
import com.exchangeratecalculator.service.application.ExchangeRateRequestDTO;
import com.exchangeratecalculator.service.application.ExchangeRateRequester;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@ActiveProfiles("dev")
public class ExchangeRateRequester_Test {
    @Autowired ExchangeRateRequester exchangeRateRequester;
    @Autowired ExchangeRateRequestProperties exchangeRateRequesterDTO;

    @Test
    @DisplayName("환율정보 요청")
    void getExchangeRate(){
        // when
        ExchangeRateRequestDTO exchangeRateRequestDTO = new ExchangeRateRequestDTO("KRW,JPY,PHP");
        ExchangeRate exchangeRate = exchangeRateRequester.getExchangeRate(exchangeRateRequesterDTO, exchangeRateRequestDTO.getCurrencies());

        // then
        assertNotNull(exchangeRate);
    }
}
