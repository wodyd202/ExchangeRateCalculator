# ExchangeRateCalculator(환율 계산기)

#### Tech
- Spring Boot
- Feign client


### EndPoint

* currencies를 입력하지 않을 경우(빈값) 환율 정보를 모두 가져옴


/api/exchange-rate?currencies=KRW,JPY

#### Install

```sh
git clone https://github.com/wodyd202/ExchangeRateCalculator.git
mvn clean spring-boot:run
```
