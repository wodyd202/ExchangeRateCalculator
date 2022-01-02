package com.exchangeratecalculator.service.application;

import com.exchangeratecalculator.config.exchangerateAPI.ExchangeRateRequestProperties;
import com.exchangeratecalculator.service.domain.ExchangeRate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 환율 정보 서비스
 */
@Service
@AllArgsConstructor
public class ExchangeRateService {
    private final ExchangeRateRequestProperties exchangeRateRequestProperties;
    private final ExchangeRateRequester exchangeRateRequester;

    /**
     * @param exchangeRateRequestDTO
     * # 환율 정보 조회
     */
    public ExchangeRate getExchangeRate(ExchangeRateRequestDTO exchangeRateRequestDTO) {
        ExchangeRate exchangeRate = exchangeRateRequester.getExchangeRate(exchangeRateRequestProperties, exchangeRateRequestDTO.getCurrencies());
        exchangeRate.validation();
        return exchangeRate;
    }
}
