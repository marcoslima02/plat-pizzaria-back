package com.system.application.pizzaria.viewmodel;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class FuncionarioVM {

    private Integer idFuncionarioVM;

    @Setter
    private LocalDate horarioTrabalhoFuncionarioVM;

    @Setter
    private BigDecimal Salario;
}
