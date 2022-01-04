package com.exchangeratecalculator.service.application;

import com.exchangeratecalculator.config.exchangerateAPI.ExchangeRateRequestProperties;
import com.exchangeratecalculator.service.domain.ExchangeRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchangeRateRequester",
             url = "${exchange-rate.uri}")
public interface ExchangeRateRequester {
    @GetMapping("live?currencies={currencies}")
    ExchangeRate getExchangeRate(@SpringQueryMap ExchangeRateRequestProperties properties,
                                 @PathVariable String currencies);
}
