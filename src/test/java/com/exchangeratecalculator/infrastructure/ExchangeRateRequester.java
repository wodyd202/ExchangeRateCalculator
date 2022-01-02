package com.exchangeratecalculator.infrastructure;

import com.exchangeratecalculator.config.exchangerateAPI.ExchangeRateRequestProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "exchangeRateRequester", url = "http://api.currencylayer.com")
public interface ExchangeRateRequester {
    @GetMapping("live")
    ExchangeRateResponse getExchangeRate(@SpringQueryMap ExchangeRateRequestProperties properties);
}
