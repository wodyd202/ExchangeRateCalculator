package com.exchangeratecalculator.domain;

import com.exchangeratecalculator.service.domain.Error;
import com.exchangeratecalculator.service.domain.ExchangeRate;
import com.exchangeratecalculator.service.domain.FaildExchangeRateRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * 환율 정보 도메인 테스트
 */
public class ExchangeRate_Test {

    @Test
    @DisplayName("환율 정보 요청 실패시 에러 발생")
    void failExchangeRateRquest(){
        // given
        ExchangeRate exchangeRate = ExchangeRate.builder()
                .success(false)
                .error(Error.builder()
                        .code(101)
                        .build())
                .build();

        // when
        assertThrows(FaildExchangeRateRequestException.class, ()->{
            exchangeRate.validation();
        });
    }
}
