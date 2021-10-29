package com.system.application.pizzaria.usecase.bebida;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.external.BebidaPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidateBebidaPreco {

    @Autowired
    private BebidaPersistenceDataBase bebidaPersistenceDataBase;

    public Boolean isBebidaValorCorrect(Bebida bebida) {
        Double valorBebidas = calculaValorBebidas(bebida);
        return bebida.getPrecoBebida().doubleValue() == valorBebidas ;
    }

    private Double calculaValorBebidas(Bebida bebida) {
        return bebida.getListaBebida().stream()
                .map(Bebida::getPrecoBebida).mapToDouble(BigDecimal::doubleValue).sum();
    }


}
