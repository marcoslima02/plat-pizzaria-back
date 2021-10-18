package com.system.application.pizzaria.viewmodel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class BebidaVM {

    private Integer idBebidaVM;
    private String nomeBebidaVM;
    private Integer quantidadeBebidaVM;
    private BigDecimal precoBebidaVM;

}
