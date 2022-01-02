package com.exchangeratecalculator.service.application;

import com.exchangeratecalculator.config.exchangerateAPI.ExchangeRateRequestProperties;
import com.exchangeratecalculator.service.domain.ExchangeRate;
import com.exchangeratecalculator.service.domain.FaildExchangeRateRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

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
    @Retryable(maxAttempts = 2,
               value = FaildExchangeRateRequestException.class,
               backoff = @Backoff(delay = 1000))
    @Cacheable(value = "exchange-rate", key = "#exchangeRateRequestDTO.currencies")
    public ExchangeRate getExchangeRate(ExchangeRateRequestDTO exchangeRateRequestDTO) {
        ExchangeRate exchangeRate = exchangeRateRequester.getExchangeRate(exchangeRateRequestProperties, exchangeRateRequestDTO.getCurrencies());
        exchangeRate.validation();
        return exchangeRate;
    }
}
