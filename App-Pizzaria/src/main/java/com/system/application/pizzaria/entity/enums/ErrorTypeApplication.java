package com.system.application.pizzaria.entity.enums;

public enum ErrorTypeApplication {

    ERRO_ATENDENTE(0,"Erro inesperado atendente"),
    ERRO_ENDERECO(1,"Erro inesperado Endereco");

    private final Integer codigo;
    private final String message;

    ErrorTypeApplication(int codigo, String message) {
        this.codigo = codigo;
        this.message = message;
    }
}
