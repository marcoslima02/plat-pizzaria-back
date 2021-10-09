package com.system.application.pizzaria.exception;

import com.system.application.pizzaria.entity.enums.ErrorType;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class IngredienteException extends GenericException {
    public IngredienteException(ErrorType errorType, String message, Date localDateTime, HttpStatus httpStatus) {
        super(errorType, message, localDateTime, httpStatus);
    }
}
