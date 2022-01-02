package com.exchangeratecalculator.config.exchangerateAPI;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "exchange-rate")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExchangeRateRequestProperties {
    private String access_key;
    private int format;
}
