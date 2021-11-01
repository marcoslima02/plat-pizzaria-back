package com.system.application.pizzaria.usecase.atendente;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.exception.AtendenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnricherAtendente {

    @Autowired
    private GetAtendenteById getAtendenteById;

    public Pedido enricherAtendente(Pedido pedido) throws AtendenteException {
        Atendente atendente = getAtendenteById.getAtendeteById(pedido.getAtendenteResponsavelPedido().getIdAtendente());
        pedido.setAtendenteResponsavelPedido(atendente);
        return pedido;
    }
}
