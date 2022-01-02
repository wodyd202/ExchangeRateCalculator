package com.exchangeratecalculator.presentation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 환율 정보 API 테스트
 */
@AutoConfigureMockMvc
@SpringBootTest
public class ExchangeRateAPI_Test {
    @Autowired MockMvc mockMvc;

    @Test
    @DisplayName("환율 정보 요청")
    void requestExchangeRate() throws Exception {
        // when
        mockMvc.perform(get("/api/exchange-rate")
                        .param("currencies","KRW,JPY,PHP"))

        // then
        .andExpect(status().isOk())
        .andExpect(jsonPath("$..['success']").exists())
        .andExpect(jsonPath("$..['terms']").exists())
        .andExpect(jsonPath("$..['privacy']").exists())
        .andExpect(jsonPath("$..['timestamp']").exists())
        .andExpect(jsonPath("$..['source']").exists())
        .andExpect(jsonPath("$..['quotes']").exists())
        .andExpect(jsonPath("$..quotes['USDJPY']").exists())
        .andExpect(jsonPath("$..quotes['USDKR']").exists())
        .andExpect(jsonPath("$..quotes['USDPHP']").exists());
    }

    @Test
    @DisplayName("환율 정보 요청 실패시 400 에러")
    void requestExchangeRate_400() throws Exception{
        // when
        mockMvc.perform(get("/api/exchange-rate"))

        // then
        .andExpect(status().isBadRequest());
    }
}
