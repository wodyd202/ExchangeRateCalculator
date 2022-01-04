package com.exchangeratecalculator.service.application;

import com.exchangeratecalculator.config.exchangerateAPI.ExchangeRateRequestProperties;
import com.exchangeratecalculator.service.domain.ExchangeRate;
import com.exchangeratecalculator.service.domain.FaildExchangeRateRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * 환율 정보 서비스
 */
@Service
@AllArgsConstructor
@Slf4j
public class ExchangeRateService {
    private final ExchangeRateRequestProperties exchangeRateRequestProperties;
    private final ExchangeRateRequester exchangeRateRequester;

    /**
     * @param exchangeRateRequestDTO
     * # 환율 정보 조회
     */
    @Retryable(maxAttempts = 3,
               include = FaildExchangeRateRequestException.class,
               backoff = @Backoff(delay = 1000))
    public ExchangeRate getExchangeRate(ExchangeRateRequestDTO exchangeRateRequestDTO) {
        ExchangeRate exchangeRate = exchangeRateRequester.getExchangeRate(exchangeRateRequestProperties, exchangeRateRequestDTO.getCurrencies());
        log.info("request exchange rate");
        exchangeRate.validation();
        return exchangeRate;
    }
}
