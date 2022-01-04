package com.exchangeratecalculator.service.presenation;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

public class InvalidRequestException extends RuntimeException {
    private final Errors errors;

    public InvalidRequestException(Errors errors) {
        this.errors = errors;
    }

    public List<String> getAllErrors(){
        return errors.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
    }
}
