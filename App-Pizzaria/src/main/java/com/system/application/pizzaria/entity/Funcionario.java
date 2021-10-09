package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Funcionario extends User {

    private LocalDateTime horarioTrabalho;
    private BigDecimal salario;

}
