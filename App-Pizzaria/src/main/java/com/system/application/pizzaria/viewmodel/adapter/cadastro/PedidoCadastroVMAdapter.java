package com.system.application.pizzaria.viewmodel.adapter.cadastro;

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
import com.system.application.pizzaria.viewmodel.adapter.AtendenteVMAdapter;
import com.system.application.pizzaria.viewmodel.adapter.BebidaVMAdapter;
import com.system.application.pizzaria.viewmodel.adapter.CozinheiroVMAdapter;
import com.system.application.pizzaria.viewmodel.adapter.PizzaVMAdapter;
import com.system.application.pizzaria.viewmodel.cadastro.PedidoCadastroVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import org.springframework.http.HttpStatus;

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
            pedido.setAtendenteResponsavelPedido(AtendenteVMAdapter.viewModelToEntity(pedidoCadastroVM.getAtendenteResponsavelVM()));
            pedido.setCozinheiroResponsavelPedido(CozinheiroVMAdapter.viewModelToEntity(pedidoCadastroVM.getCozinheiroResponsavelVM()));
            pedido.setStatusPedido(StatusPedido.AGUARDANDO);
            pedido.setHorarioPedido(LocalDate.now().atStartOfDay());
            pedido.setHorarioEstimadoPedido(pedido.getHorarioPedido().plusHours(1));
            pedido.setPrecoPedido(pedidoCadastroVM.getPrecoTotalPedido());
            pedido.setComentarioPedido(pedidoCadastroVM.getComentarioPedidoCadastroVM());
            percorreListaBebida(pedidoCadastroVM, listBebidas);
            percorreListaPizza(pedidoCadastroVM, listPizzas);
            pedido.setListaBebidaPedido(listBebidas);
            pedido.setListaPizzaPedido(listPizzas);
            pedido.setAtendenteResponsavelPedido(AtendenteVMAdapter.viewModelToEntity(pedidoCadastroVM.getAtendenteResponsavelVM()));
            pedido.setCozinheiroResponsavelPedido(CozinheiroVMAdapter.viewModelToEntity(pedidoCadastroVM.getCozinheiroResponsavelVM()));
            return pedido;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer cadastro adapter de PedidoCadastroVM para Pedido");
            throw new PedidoException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pedido is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static PedidoCadastroVM entityToViewModel(Pedido pedido) throws PedidoException {
        PedidoCadastroVM pedidoCadastroVM = new PedidoCadastroVM();
        List<BebidaVM> listBebidasVM = new ArrayList<>();
        List<PizzaVM> listPizzasVM = new ArrayList<>();
        try {
            pedidoCadastroVM.setAtendenteResponsavelVM(AtendenteVMAdapter.entityToViewModel(pedido.getAtendenteResponsavelPedido()));
            pedidoCadastroVM.setCozinheiroResponsavelVM(CozinheiroVMAdapter.entityToViewModel(pedido.getCozinheiroResponsavelPedido()));
            pedidoCadastroVM.setPrecoTotalPedido(pedido.getPrecoPedido());
            pedidoCadastroVM.setComentarioPedidoCadastroVM(pedido.getComentarioPedido());
            percorreListaBebidaEntity(pedido, listBebidasVM);
            percorreListaPizzaEntity(pedido, listPizzasVM);
            pedidoCadastroVM.setPizzaVMList(listPizzasVM);
            pedidoCadastroVM.setBebidaVMList(listBebidasVM);
            return pedidoCadastroVM;

        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer cadastro adapter Pedido de para PedidoCadastroVM");
            throw new PedidoException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pedido is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void percorreListaPizzaEntity(Pedido pedido, List<PizzaVM> listPizzasVM) {
        pedido.getListaPizzaPedido().forEach(pizza -> {
            try {
                listPizzasVM.add(PizzaVMAdapter.entityToViewModel(pizza));
            } catch (PizzaException e) {
                e.printStackTrace();
            }
        });
    }

    private static void percorreListaBebidaEntity(Pedido pedido, List<BebidaVM> listBebidasVM) {
        pedido.getListaBebidaPedido().forEach(bebida -> {
            try {
                listBebidasVM.add(BebidaVMAdapter.entityToViewModel(bebida));
            } catch (BebidaException e) {
                e.printStackTrace();
            }
        });
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
