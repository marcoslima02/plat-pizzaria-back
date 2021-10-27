package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.PedidoCadastroVM;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoCadastroVMAdapter {

    public static Pedido viewModelToEntity(PedidoCadastroVM pedidoCadastroVM) throws PedidoException {
        Pedido pedido = new Pedido();
        List<Bebida> listBebidas = new ArrayList<>();
        List<Pizza> listPizzas = new ArrayList<>();

        try {
            pedido.setStatusPedido(StatusPedido.AGUARDANDO);
            pedido.setHorarioPedido(LocalDate.now().atStartOfDay());
            pedido.setHorarioEstimadoPedido(pedido.getHorarioPedido().plusHours(1));
            pedido.setPrecoPedido(pedidoCadastroVM.getPrecoTotalPedido());
            pedido.setComentarioPedido(pedidoCadastroVM.getComentarioPedidoCadastroVM());
            percorreListaBebida(pedidoCadastroVM, listBebidas);
            percorreListaPizza(pedidoCadastroVM, listPizzas);
            pedido.setListaBebidaPedido(listBebidas);
            pedido.setListaPizzaPedido(listPizzas);

        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PedidoCadastroVM para Pedido");
            throw new PedidoException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pedido is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return pedido;
    }

    private static void percorreListaPizza(PedidoCadastroVM pedidoCadastroVM, List<Pizza> listPizzas) {
        pedidoCadastroVM.getPizzaVMList().forEach(pizzaVM -> {
            try {
                listPizzas.add(PizzaVMAdapter.viewModelToEntity(pizzaVM));
            } catch (PizzaException e) {
                e.printStackTrace();
            }
        });
    }

    private static void percorreListaBebida(PedidoCadastroVM pedidoCadastroVM, List<Bebida> listBebidas) {
        pedidoCadastroVM.getBebidaVMList().forEach(bebidaVM -> {
            try {
                listBebidas.add(BebidaVMAdapter.viewModelToEntity(bebidaVM));
            } catch (BebidaException e) {
                e.printStackTrace();
            }
        });
    }

}
