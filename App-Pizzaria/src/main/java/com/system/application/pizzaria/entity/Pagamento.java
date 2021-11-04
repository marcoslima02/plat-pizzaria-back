package com.system.application.pizzaria.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class Pagamento {

    private Integer idPagamento;
    private String funcionarioPagamento;
    private BigDecimal salarioPagamento;

}
