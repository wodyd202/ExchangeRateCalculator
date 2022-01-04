package com.exchangeratecalculator.service.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Error {
    private int code;

    @Builder
    public Error(int code) {
        this.code = code;
    }

    public boolean is202Error() {
        return code == 202;
    }

    public boolean is101Error() {
        return code == 101;
    }

    public boolean is106Error(){
        return code == 106;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code=" + code +
                '}';
    }
}
