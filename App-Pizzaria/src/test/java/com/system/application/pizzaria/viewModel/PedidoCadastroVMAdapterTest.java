package com.system.application.pizzaria.viewModel;


import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.viewmodel.PedidoCadastroVM;
import com.system.application.pizzaria.viewmodel.adapter.PedidoCadastroVMAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class PedidoCadastroVMAdapterTest {

    private Pedido pedido = criaEntidadePedido();
    private PedidoCadastroVM pedidoCadastroVM = criaEntidadePedidoCadastroVM();

    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() throws PedidoException {
        //Arrange
        Pedido pedidoExpected = criaEntidadePedido();
        //Act
        Pedido pedidoActual = PedidoCadastroVMAdapter.viewModelToEntity(pedidoCadastroVM);
        //Assert
        assertEquals(pedidoExpected, pedidoActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToVM() throws PedidoException {
        //Arrange
        PedidoCadastroVM pedidoCadastroVMExpected = criaEntidadePedidoCadastroVM();
        //Act
        PedidoCadastroVM pedidoCadastroVMActual = PedidoCadastroVMAdapter.entityToViewModel(pedido);
        //Assert
        assertEquals(pedidoCadastroVMExpected, pedidoCadastroVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            PedidoCadastroVMAdapter.entityToViewModel(null);
        } catch (PedidoException e) {
            assertEquals("Adapter entityToViewModel Pedido is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithViewModelNullTest() {
        //Act
        try {
            PedidoCadastroVMAdapter.viewModelToEntity(null);
        } catch (PedidoException e) {
            assertEquals("Adapter viewModelToEntity Pedido is Null", e.getMessage());
        }
    }

    public Pedido criaEntidadePedido() {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(1);
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);
        pedido.setHorarioPedido(LocalDateTime.now());
        pedido.setHorarioEstimadoPedido(LocalDateTime.now());
        pedido.setPrecoPedido(new BigDecimal("59.00"));
        pedido.setComentarioPedido("fnfsjngdsnofgjlig, dhufsufhsfgbhsbgf fdhiuashfihasidf.");

        return pedido;
    }

    public PedidoCadastroVM criaEntidadePedidoCadastroVM() {
        PedidoCadastroVM pedidoCadastroVM = new PedidoCadastroVM();
        pedidoCadastroVM.setIdPedidoCadastroVM(1);
        pedidoCadastroVM.setStatusPedidoCadastroVM(StatusPedido.AGUARDANDO);
        pedidoCadastroVM.setHorarioPedidoCadastroVM(LocalDateTime.now());
        pedidoCadastroVM.setHorarioEstimadoPedidoCadastroVM(LocalDateTime.now());
        pedidoCadastroVM.setPrecoPedidoCadastroVM(new BigDecimal("59.00"));
        pedidoCadastroVM.setComentarioPedidoCadastroVM("fnfsjngdsnofgjlig, dhufsufhsfgbhsbgf fdhiuashfihasidf.");

        return pedidoCadastroVM;
    }
}
