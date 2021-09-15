package com.system.application.pizzaria.entity.enums;

import lombok.Getter;

@Getter
public enum CategoriaPizza {

    TRADICIONAL(01),
    VEGANA(02),
    LIGHT(03),
    SEM_GLUTEN(04),
    SEM_LACTOSE(05),
    ESPECIAL(06),
    DOCE(07);

    private final Integer codigo;

    CategoriaPizza(Integer codigo) {
        this.codigo = codigo;
    }
}
