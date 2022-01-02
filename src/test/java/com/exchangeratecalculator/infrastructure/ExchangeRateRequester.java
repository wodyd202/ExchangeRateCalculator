package com.exchangeratecalculator.infrastructure;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "exchangeRateRequester", url = "http://api.currencylayer.com")
public interface ExchangeRateRequester {
    @GetMapping("live")
    ExchangeRateResponse get(@SpringQueryMap ExchangeRateRequesterDTO exchangeRateRequesterDTO);
}
