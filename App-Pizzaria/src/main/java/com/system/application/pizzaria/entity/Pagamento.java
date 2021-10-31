package com.system.application.pizzaria.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Pagamento {

    private Integer idPagamento;
    private String funcionarioPagamento;
    private Double salarioPagamento;

}
