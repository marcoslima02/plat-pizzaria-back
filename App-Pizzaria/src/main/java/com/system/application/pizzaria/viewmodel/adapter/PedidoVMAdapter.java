package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.*;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.PedidoVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoVMAdapter {

    public static Pedido viewModelToEntity(PedidoVM pedidoVM) throws PedidoException {
        Pedido pedido = new Pedido();
        List<Pizza> pizzaList = new ArrayList<>();
        List<Bebida> bebidaList = new ArrayList<>();

        try {
            pedido.setIdPedido(pedidoVM.getIdPedidoVM());
            pedido.setStatusPedido(pedidoVM.getStatusPedidoVM());
            validadeIsNullVMToEntity(pedidoVM, pizzaList, bebidaList);
            pedido.setListaBebidaPedido(bebidaList);
            pedido.setListaPizzaPedido(pizzaList);
            pedido.setHorarioPedido(pedidoVM.getHorarioPedidoVM());
            pedido.setHorarioEstimadoPedido(pedidoVM.getHorarioEstimadoPedidoVM());
            pedido.setPrecoPedido(pedidoVM.getPrecoPedidoVM());
            pedido.setComentarioPedido(pedidoVM.getComentarioPedidoVM());
            validateCozinheiroIsNullVMToEntity(pedidoVM, pedido);
            validateAtendenteisNullVmTOEntity(pedidoVM, pedido);
            return pedido;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Pedido para PedidoVM");
            throw new PedidoException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pedido is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validateAtendenteisNullVmTOEntity(PedidoVM pedidoVM, Pedido pedido) throws AtendenteException {
        if (pedidoVM.getNomeAtendenteVM() != null) {
            pedido.setAtendenteResponsavelPedido(AtendenteVMAdapter.viewModelToEntity(pedidoVM.getNomeAtendenteVM()));
        }
    }

    private static void validateCozinheiroIsNullVMToEntity(PedidoVM pedidoVM, Pedido pedido) throws CozinheiroException {
        if (pedidoVM.getNomeCozinheiroVM() != null) {
            pedido.setCozinheiroResponsavelPedido(CozinheiroVMAdapter.viewModelToEntity(pedidoVM.getNomeCozinheiroVM()));
        }
    }

    private static void validadeIsNullVMToEntity(PedidoVM pedidoVM, List<Pizza> pizzaList, List<Bebida> bebidaList) {
        if (pedidoVM.getListaBebidaVMPedidoVM() != null) {
            percorreListaBebidaVMToEntity(pedidoVM, bebidaList);
        }
        if (pedidoVM.getListaPizzaVMPedidoVM() != null) {
            percorreListaPizzaVMToEntity(pedidoVM, pizzaList);
        }
    }

    private static void percorreListaBebidaVMToEntity(PedidoVM pedidoVM, List<Bebida> bebidaList) {
        pedidoVM.getListaBebidaVMPedidoVM().forEach(bebidaVM -> {
            try {
                bebidaList.add(BebidaVMAdapter.viewModelToEntity(bebidaVM));
            } catch (BebidaException e) {
                e.printStackTrace();
            }
        });
    }

    private static void percorreListaPizzaVMToEntity(PedidoVM pedidoVM, List<Pizza> pizzaList) {
        pedidoVM.getListaPizzaVMPedidoVM().forEach(pizzaVM -> {
            try {
                pizzaList.add(PizzaVMAdapter.viewModelToEntity(pizzaVM));
            } catch (PizzaException e) {
                e.printStackTrace();
            }
        });
    }

    public static PedidoVM entityToViewModel(Pedido pedido) throws PedidoException {
        PedidoVM pedidoVM = new PedidoVM();
        List<PizzaVM> pizzaVMList = new ArrayList<>();
        List<BebidaVM> bebidaVMList = new ArrayList<>();

        try {
            pedidoVM.setIdPedidoVM(pedido.getIdPedido());
            pedidoVM.setStatusPedidoVM(pedido.getStatusPedido());
            validaIsNullEntityToVM(pedido, pizzaVMList, bebidaVMList);
            pedidoVM.setListaPizzaVMPedidoVM(pizzaVMList);
            pedidoVM.setListaBebidaVMPedidoVM(bebidaVMList);
            pedidoVM.setHorarioPedidoVM(pedido.getHorarioPedido());
            pedidoVM.setHorarioEstimadoPedidoVM(pedido.getHorarioEstimadoPedido());
            pedidoVM.setPrecoPedidoVM(pedido.getPrecoPedido());
            pedidoVM.setComentarioPedidoVM(pedido.getComentarioPedido());
            validateCozinheiroIsNullEntityToVM(pedido, pedidoVM);
            validateAtendenteIsNullEntityToVM(pedido, pedidoVM);
            return pedidoVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Pedido para PedidoViewModel");
            throw new PedidoException(ErrorType.VALIDATIONS, "Adapter entityToViewModel Pedido is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validateAtendenteIsNullEntityToVM(Pedido pedido, PedidoVM pedidoVM) throws AtendenteException {
        if (pedido.getAtendenteResponsavelPedido() != null) {
            pedidoVM.setNomeAtendenteVM(AtendenteVMAdapter.entityToViewModel(pedido.getAtendenteResponsavelPedido()));
        }
    }

    private static void validateCozinheiroIsNullEntityToVM(Pedido pedido, PedidoVM pedidoVM) throws CozinheiroException {
        if (pedido.getCozinheiroResponsavelPedido() != null) {
            pedidoVM.setNomeCozinheiroVM(CozinheiroVMAdapter.entityToViewModel(pedido.getCozinheiroResponsavelPedido()));
        }
    }

    private static void validaIsNullEntityToVM(Pedido pedido, List<PizzaVM> pizzaVMList, List<BebidaVM> bebidaVMList) {
        if (pedido.getListaPizzaPedido() != null) {
            percorreListaPizzaEntityToVM(pedido, pizzaVMList);
        }

        if (pedido.getListaBebidaPedido() != null) {
            percorreListaBebidaEntityToVM(pedido, bebidaVMList);
        }
    }

    private static void percorreListaBebidaEntityToVM(Pedido pedido, List<BebidaVM> bebidaVMList) {
        pedido.getListaBebidaPedido().forEach(bebida -> {
            try {
                bebidaVMList.add(BebidaVMAdapter.entityToViewModel(bebida));
            } catch (BebidaException e) {
                e.printStackTrace();
            }
        });
    }

    private static void percorreListaPizzaEntityToVM(Pedido pedido, List<PizzaVM> pizzaVMList) {
        pedido.getListaPizzaPedido().forEach(pizza -> {
            try {
                pizzaVMList.add(PizzaVMAdapter.entityToViewModel(pizza));
            } catch (PizzaException e) {
                e.printStackTrace();
            }
        });
    }

    public static List<PedidoVM> entityListToViewModelList(List<Pedido> pedidoList) {
        List<PedidoVM> pedidoVMList = new ArrayList<>();
        pedidoList.forEach(pedido -> {
            try {
                pedidoVMList.add(entityToViewModel(pedido));
            } catch (PedidoException e) {
                e.printStackTrace();
            }
        });
        return pedidoVMList;
    }

    public static List<Pedido> viewModelListToEntityList(List<PedidoVM> pedidoVMList) {
        List<Pedido> pedidoList = new ArrayList<>();
        pedidoVMList.forEach(pedidoVM -> {
            try {
                pedidoList.add(viewModelToEntity(pedidoVM));
            } catch (PedidoException e) {
                e.printStackTrace();
            }
        });
        return pedidoList;
    }

}


