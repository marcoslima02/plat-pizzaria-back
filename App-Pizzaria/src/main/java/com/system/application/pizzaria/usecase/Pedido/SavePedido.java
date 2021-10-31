package com.system.application.pizzaria.usecase.Pedido;


import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.external.BebidaPersistenceDataBase;
import com.system.application.pizzaria.external.PedidoPersistenceDataBase;
import com.system.application.pizzaria.external.PizzaPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SavePedido {

    @Autowired
    private PedidoPersistenceDataBase pedidoPersistenceDataBase;

    @Autowired
    private ValidateTotalPrecoPedido validateTotalPrecoPedido;

    public Pedido savePedido(Pedido pedido) throws PedidoException {
        if(validateTotalPrecoPedido.isTotalPedidoCorrect(pedido)){
            return pedidoPersistenceDataBase.savePedido(pedido);
        }
        throw new PedidoException(ErrorType.ERRO_TOTAL_PRICE_PEDIDO, "Preço total do pedido esta errado", new Date(), HttpStatus.BAD_REQUEST);
    }
}
