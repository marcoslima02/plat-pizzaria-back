package com.system.application.pizzaria.external;

import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.exception.PedidoException;

import java.util.List;

public interface PedidoPersistenceDataBase {
    List<Pedido> getAllPedidos();

    Pedido getPedidoById(Integer idPedido) throws PedidoException;

    Pedido savePedido(Pedido pedido) throws PedidoException;
}
