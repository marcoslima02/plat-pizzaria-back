package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.PedidoVM;
import com.system.application.pizzaria.viewmodel.adapter.PedidoVMAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class PedidoVMAdapterTest {

    private Pedido pedido = criaEntidadePedido();
    private PedidoVM pedidoVM = criaEntidadePedidoVM();


    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() throws PedidoException {
        //Arrange
        Pedido pedidoExpected = criaEntidadePedido();
        //Act
        Pedido pedidoActual = PedidoVMAdapter.viewModelToEntity(pedidoVM);
        //Assert
        assertEquals(pedidoExpected, pedidoActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToVM() throws PedidoException {
        //Arrange
        BebidaVM pedidoVMExpected = criaEntidadePedidoVM();
        //Act
        BebidaVM pedidoVMActual = PedidoVMAdapter.entityToViewModel(pedido);
        //Assert
        assertEquals(pedidoVMExpected, pedidoVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            PedidoVMAdapter.entityToViewModel(null);
        } catch (PedidoException e) {
            assertEquals("Adapter entityToVM Pedido is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            PedidoVMAdapter.viewModelToEntity(null);
        } catch (PedidoException e) {
            assertEquals("Adapter VMToEntity Pedido is Null", e.getMessage());
        }
    }

    public Pedido criaEntidadePedido() {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(1);
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);
        pedido.setListaPizzaPedido();
        pedido.setListaBebidaPedido();
        pedido.setHorarioPedido("17:00");
        pedido.setHorarioEstimadoPedido("17:00");
        pedido.setPrecoPedido(new BigDecimal("59.00"));
        pedido.setComentarioPedido("fnfsjngdsnofgjlig, dhufsufhsfgbhsbgf fdhiuashfihasidf.");
        return pedido;

    }

    public PedidoVM criaEntidadePedidoVM() {
        PedidoVM pedidoVM = new PedidoVM();
        pedidoVM.setIdPedidoVM(1);
        pedidoVM.setStatusPedidoVM(StatusPedido.AGUARDANDO);
        pedidoVM.setListaPizzaVMPedidoVM();
        pedidoVM.setListaBebidaVMPedidoVM();
        pedidoVM.setHorarioPedidoVM(new localDateTime("17:00"));
        pedidoVM.setHorarioEstimadoPedidoVM("17:00");
        pedidoVM.setPrecoPedidoVM(new BigDecimal("59.00"));
        pedidoVM.setComentarioPedidoVM("fnfsjngdsnofgjlig, dhufsufhsfgbhsbgf fdhiuashfihasidf.");
        return pedidoVM;

    }

}
