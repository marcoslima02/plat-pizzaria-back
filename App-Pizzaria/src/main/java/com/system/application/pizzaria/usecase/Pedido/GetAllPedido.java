package com.system.application.pizzaria.usecase.Pedido;


import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.external.PedidoPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPedido {

    @Autowired
    private PedidoPersistenceDataBase pedidoPersistenceDataBase;

    public List<Pedido> getAllPedidos() throws PedidoException {
        return pedidoPersistenceDataBase.getAllPedidos();
    }
}
