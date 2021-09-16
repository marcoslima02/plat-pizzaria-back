package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public abstract class FuncionarioModel extends UserModel{

    private LocalDateTime horarioTrabalho;
    private BigDecimal salario;
}
