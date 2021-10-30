package com.system.application.pizzaria.entity.enums;

import lombok.Getter;

@Getter
public enum CategoriaPizza {

    TRADICIONAL(00),
    VEGANA(01),
    LIGHT(02),
    SEM_GLUTEN(03),
    SEM_LACTOSE(04),
    ESPECIAL(05),
    DOCE(06);

    private final Integer codigo;

    CategoriaPizza(Integer codigo) {
        this.codigo = codigo;
    }
}
