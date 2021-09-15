package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public abstract class Funcionario extends User {

    private Integer idFuncionario;

    @Setter
    private LocalDate horarioTrabalho;

    @Setter
    private BigDecimal salario;
}
