package com.system.application.pizzaria.usecase.Pedido;

import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.external.PedidoPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetPedidoById {

    @Autowired
    private PedidoPersistenceDataBase pedidoPersistenceDataBase;

    public Pedido getPedidoById(Integer idPedido) throws PedidoException {
        return pedidoPersistenceDataBase.getPedidoById(idPedido);
    }
}
