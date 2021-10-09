package com.system.application.pizzaria.viewmodel;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class FuncionarioVM extends UserVM{

    private Integer idFuncionarioVM;
    private LocalDateTime horarioTrabalhoVM;
    private BigDecimal SalarioVM;

}
