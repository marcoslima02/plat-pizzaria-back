package com.system.application.pizzaria.exception;

import com.system.application.pizzaria.entity.enums.ErrorType;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class GenericException extends Exception{

    @Getter
    private final ErrorType errorType;

    @Getter
    private final String message;

    @Getter
    private final Date date;

    @Getter
    private final HttpStatus httpStatus;

    public GenericException(ErrorType errorType, String message, Date date, HttpStatus httpStatus) {
        super(message, null, false, false);
        this.errorType = errorType;
        this.message = message;
        this.date = date;
        this.httpStatus = httpStatus;
    }
}
