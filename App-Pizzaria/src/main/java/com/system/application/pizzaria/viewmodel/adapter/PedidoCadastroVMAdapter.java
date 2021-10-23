package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.ClienteCadastroVM;
import com.system.application.pizzaria.viewmodel.PedidoCadastroVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoCadastroVMAdapter {

    public static Pedido viewModelToEntity(PedidoCadastroVM pedidoCadastroVM) throws PedidoException {
        Pedido pedido = new Pedido();

        try {
            pedido.setIdPedido(pedidoCadastroVM.getIdPedidoCadastroVM());
            pedido.setStatusPedido(pedidoCadastroVM.getStatusPedidoCadastroVM());
            pedido.setHorarioPedido(pedidoCadastroVM.getHorarioPedidoCadastroVM());
            pedido.setHorarioEstimadoPedido(pedidoCadastroVM.getHorarioEstimadoPedidoCadastroVM());
            pedido.setPrecoPedido(pedidoCadastroVM.getPrecoPedidoCadastroVM());
            pedido.setComentarioPedido(pedidoCadastroVM.getComentarioPedidoCadastroVM());

        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PedidoCadastroVM para Pedido");
            throw new PedidoException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pedido is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return pedido;
    }

    public static PedidoCadastroVM entityToViewModel(Pedido pedido) throws PedidoException {
        PedidoCadastroVM pedidoCadastroVM = new PedidoCadastroVM();

        try {
            pedidoCadastroVM.setIdPedidoCadastroVM(pedido.getIdPedido());
            pedidoCadastroVM.setStatusPedidoCadastroVM(pedido.getStatusPedido());
            pedidoCadastroVM.setHorarioPedidoCadastroVM(pedido.getHorarioPedido());
            pedidoCadastroVM.setHorarioEstimadoPedidoCadastroVM(pedido.getHorarioEstimadoPedido());
            pedidoCadastroVM.setPrecoPedidoCadastroVM(pedido.getPrecoPedido());
            pedidoCadastroVM.setComentarioPedidoCadastroVM(pedido.getComentarioPedido());

        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Pedido para PedidoCadastroVM");
            throw new PedidoException(ErrorType.VALIDATIONS, "Adapter entityToViewModel Pedido is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return pedidoCadastroVM;
    }

}
