package com.system.application.pizzaria.usecase.Pedido;

import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.exception.PedidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnricherPedido {

    @Autowired
    private GetPedidoById getPedidoById;

    public Pedido enricherPedido(Integer id) throws PedidoException {
        return getPedidoById.getPedidoById(id);
    }
}
