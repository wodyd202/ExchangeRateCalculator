package com.exchangeratecalculator.service.domain;

import lombok.*;

import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExchangeRate {
    private boolean success;
    private String terms;
    private String privacy;
    private long timestamp;
    private String source;
    private Map<String,Double> quotes;

    @Builder
    public ExchangeRate(boolean success, String terms, String privacy, long timestamp, String source, Map<String,Double> quotes) {
        this.success = success;
        this.terms = terms;
        this.privacy = privacy;
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
    }

    public void validation() {
        if(!success){
            throw new FaildExchangeRateRequestException();
        }
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "success=" + success +
                ", terms='" + terms + '\'' +
                ", privacy='" + privacy + '\'' +
                ", timestamp=" + timestamp +
                ", source='" + source + '\'' +
                ", quotes=" + quotes +
                '}';
    }
}
