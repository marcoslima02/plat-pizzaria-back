package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "TB_FUNCIONARIO")
public abstract class FuncionarioModel extends UserModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idFuncionarioModel;

    @Column(name = "HORARIO_TRABALHO", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime horarioTrabalhoModel;

    @Column(name = "SALARIO", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal salarioModel;

}
