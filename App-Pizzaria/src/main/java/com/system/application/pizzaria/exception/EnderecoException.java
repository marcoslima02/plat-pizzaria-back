package com.system.application.pizzaria.exception;

import com.system.application.pizzaria.entity.enums.ErrorTypeApplication;
import lombok.Getter;

import static com.system.application.pizzaria.entity.enums.ErrorTypeApplication.ERRO_ATENDENTE;

public class EnderecoException extends RuntimeException{

    @Getter
    private final ErrorType errorType;

    @Getter
    private final String message;

    public EnderecoException(EnderecoException.ErrorType errorType, String message) {
        this.errorType = errorType;
        this.message = message;
    }

    public enum ErrorType{
        VALIDATIONS(ERRO_ATENDENTE, ERRO_ATENDENTE);

        private final ErrorTypeApplication codigoErro;
        private final ErrorTypeApplication message;

        ErrorType(ErrorTypeApplication codigoErro, ErrorTypeApplication messageErro) {
            this.codigoErro = codigoErro;
            this.message = messageErro;
        }
    }
}
