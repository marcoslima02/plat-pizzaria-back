package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="TB_Funcionarios")
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idFuncionarioModel;

    @Column(name = "HORARIO_TRABALHO", nullable = false, columnDefinition = "DATE")
    private LocalDate horarioTrabalhoFuncionarioModel;

    @Column(name = "SALRIO", nullable = false, columnDefinition = "DECIMAL")
    private BigDecimal salarioFuncionarioModel;
}
