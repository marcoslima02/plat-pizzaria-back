package com.system.application.pizzaria.external.database.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "TB_PAGAMENTOS")
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idPagamentoModel;

    @Column(name = "FUNCIONARIOS", nullable = false, columnDefinition = "VARCHAR(100)")
    private String funcionarioPagamentoModel;

    @Column(name = "SALARIOS", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal salarioPagamentoModel;

    @ManyToOne
    private AdministradorModel administradorModel;

}
