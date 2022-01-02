package com.exchangeratecalculator.config.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableFeignClients(basePackages = "com.exchangeratecalculator")
@Profile("!test")
public class FeignConfig {
}
