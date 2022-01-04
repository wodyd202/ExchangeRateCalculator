package com.exchangeratecalculator.service.domain;

import lombok.*;

import java.util.Map;

/**
 * 환율 정보
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExchangeRate {
    private boolean success;
    private String terms;
    private String privacy;
    private long timestamp;
    private String source;
    private Map<String, Double> quotes;
    private Error error;

    @Builder
    public ExchangeRate(boolean success, String terms, String privacy, long timestamp, String source, Map<String,Double> quotes, Error error) {
        this.success = success;
        this.terms = terms;
        this.privacy = privacy;
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
        this.error = error;
    }

    public void validation() {
        if(!success && error.is202Error()){
            throw new FaildExchangeRateRequestException("환율 요청 정보가 잘못되었습니다. 국가명을 다시 확인해주세요.");
        }
        if(!success && (error.is101Error() || error.is106Error())){
            throw new FaildExchangeRateRequestException("환율 정보를 가져오지 못했습니다. 잠시 후 다시 시도해주세요.");
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
                ", error=" + error +
                '}';
    }
}
