package com.exchangeratecalculator.infrastructure;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExchangeRateResponse {
    private boolean success;
    private String terms;
    private String privacy;
    private long timestamp;
    private String source;
    private Quotes quotes;

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Quotes {
        private double USDKRW;
        private double USDJPY;
        private double USDPHP;

        public Quotes(double USDKRW, double USDJPY, double USDPHP) {
            this.USDKRW = USDKRW;
            this.USDJPY = USDJPY;
            this.USDPHP = USDPHP;
        }
    }
}
