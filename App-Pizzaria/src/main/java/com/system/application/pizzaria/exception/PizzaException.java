package com.system.application.pizzaria.exception;

import com.sun.tools.attach.AgentLoadException;
import com.system.application.pizzaria.entity.enums.ErrorType;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class PizzaException extends GenericException {
public PizzaException(ErrorType errorType, String message, Date date, HttpStatus httpStatus) {
            super(errorType,message,date, httpStatus);
        }

}
