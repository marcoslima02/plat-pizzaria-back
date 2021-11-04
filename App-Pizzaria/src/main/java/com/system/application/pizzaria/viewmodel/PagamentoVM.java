package com.system.application.pizzaria.viewmodel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class PagamentoVM {

    private Integer idPagamentoVM;
    private String funcionarioPagamentoVM;
    private BigDecimal salarioPagamentoVM;

}
