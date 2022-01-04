package com.exchangeratecalculator.service.application;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ExchangeRateRequestDTO {
    @NotBlank(message = "환율 조회 국가를 입력해주세요.")
    private String currencies;
}
