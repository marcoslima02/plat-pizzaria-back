package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
public abstract class FuncionarioModel extends UserModel{

    @Column(name = "HORARIO_TRABALHO", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime horarioTrabalho;
    @Column(name = "SALARIO", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal salario;
}
