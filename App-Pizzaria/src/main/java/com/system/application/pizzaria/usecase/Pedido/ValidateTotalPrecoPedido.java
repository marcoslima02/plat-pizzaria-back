package com.system.application.pizzaria.usecase.Pedido;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.Pizza;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidateTotalPrecoPedido {

    public Boolean isTotalPedidoCorrect(Pedido pedido) {
        Double valorPizzas = calculaValorPizzas(pedido);
        Double valorBebidas = calculaValorBebidas(pedido);
        return pedido.getPrecoPedido().doubleValue() == valorBebidas + valorPizzas;
    }

    private Double calculaValorPizzas(Pedido pedido) {
        return pedido.getListaPizzaPedido().stream()
                .map(Pizza::getPrecoPizza).mapToDouble(BigDecimal::doubleValue).sum();

    }

    private Double calculaValorBebidas(Pedido pedido) {
        return pedido.getListaBebidaPedido().stream()
                .map(Bebida::getPrecoBebida).mapToDouble(BigDecimal::doubleValue).sum();
    }
}
