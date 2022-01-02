package com.exchangeratecalculator.config.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.exchangeratecalculator")
public class FeignConfig {
}
