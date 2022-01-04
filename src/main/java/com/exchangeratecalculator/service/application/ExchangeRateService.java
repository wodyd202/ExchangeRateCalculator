package com.exchangeratecalculator.service.application;

import com.exchangeratecalculator.config.exchangerateAPI.ExchangeRateRequestProperties;
import com.exchangeratecalculator.service.domain.ExchangeRate;
import com.exchangeratecalculator.service.domain.FaildExchangeRateRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.net.ConnectException;

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
    @Retryable(maxAttempts = 2,
               value = { ConnectException.class },
               backoff = @Backoff(delay = 1000))
    public ExchangeRate getExchangeRate(ExchangeRateRequestDTO exchangeRateRequestDTO) {
        ExchangeRate exchangeRate = exchangeRateRequester.getExchangeRate(exchangeRateRequestProperties, exchangeRateRequestDTO.getCurrencies());
        log.info("request exchange rate by : {}", exchangeRateRequestDTO.getCurrencies());
        exchangeRate.validation();
        return exchangeRate;
    }

    @Recover
    public ExchangeRate recover(Exception e){
        log.warn("request error : {}", e.getMessage());
        throw new FaildExchangeRateRequestException("환율 정보를 가져오지 못했습니다. 잠시후 다시 시도해주세요.");
    }
}
