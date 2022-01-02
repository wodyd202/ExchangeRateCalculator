package com.exchangeratecalculator;

import com.exchangeratecalculator.config.exchangerateAPI.ExchangeRateRequestProperties;
import com.exchangeratecalculator.service.application.ExchangeRateRequester;
import com.exchangeratecalculator.service.domain.ExchangeRate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile("test")
public class StubExchangeRequester implements ExchangeRateRequester {
    @Override
    public ExchangeRate getExchangeRate(ExchangeRateRequestProperties properties, String currencies) {
        if(currencies == null){
            return ExchangeRate.builder()
                    .success(false)
                    .build();
        }
        Map<String, Double> map = new HashMap<>();
        map.put("USDJPY", 1.0);
        map.put("USDKR", 2.0);
        map.put("USDPHP", 3.0);
        return ExchangeRate.builder()
                .success(true)
                .quotes(map)
                .build();
    }
}
