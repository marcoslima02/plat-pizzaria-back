package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.external.database.entity.PedidoModel;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.PedidoCadastroVM;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class PedidoCadastroModelAdapter {

    /*public static PedidoModel entityToModel(Pedido pedido) throws PedidoException {
        Pedido pedidoModel = new Pedido();

        try {
            pedidoModel.set
            pedidoModel.setStatusPedido(StatusPedido.AGUARDANDO);
            pedidoModel.setHorarioPedido(LocalDate.now().atStartOfDay());
            pedidoModel.setHorarioEstimadoPedido(pedido.getHorarioPedido().plusHours(1));
            if(pedido.getPrecoPedido().equals(null)){
                pedido.setPrecoPedido(new BigDecimal(0.00));
            }
            pedido.setComentarioPedido(pedidoCadastroVM.getComentarioPedidoCadastroVM());

        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PedidoCadastroVM para Pedido");
            throw new PedidoException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pedido is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return pedido;
    }
     */
}
