package com.system.application.pizzaria.viewmodel.adapter.forms;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.cadastro.BebidaCadastroVM;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class BebidaCadastroVMAdapter {


    public static Bebida viewModelToEntity(BebidaCadastroVM bebidaCadastroVM) throws BebidaException {
        Bebida bebida = new Bebida();
        try {
            bebida.setNomeBebida(bebidaCadastroVM.getNomeBebidaVM());
            bebida.setPrecoBebida(bebidaCadastroVM.getPrecoBebidaVM());
            bebida.setQuantidadeBebida(bebidaCadastroVM.getQuantidadeBebidaVM());
            validateIdPedidoIsNullVMToEntity(bebidaCadastroVM, bebida);

        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de BebidaCadastroVM para Bebida");
            throw new BebidaException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Bebida is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return bebida;
    }

    private static void validateIdPedidoIsNullVMToEntity(BebidaCadastroVM bebidaCadastroVM, Bebida bebida) {
        if (bebidaCadastroVM.getIdPedidoVM() != null) {
            bebida.setIdentificacaoPedido(bebidaCadastroVM.getIdPedidoVM());
        }
    }

    public static BebidaCadastroVM entityToViewModel(Bebida bebida) throws BebidaException {
        BebidaCadastroVM bebidaCadastroVM = new BebidaCadastroVM();
        try {
            bebidaCadastroVM.setNomeBebidaVM(bebida.getNomeBebida());
            bebidaCadastroVM.setPrecoBebidaVM(bebida.getPrecoBebida());
            bebidaCadastroVM.setQuantidadeBebidaVM(bebida.getQuantidadeBebida());
            validateIdPedidoIsNullEntityToVM(bebida, bebidaCadastroVM);
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Bebida para BebidaCadastroVM");
            throw new BebidaException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Bebida is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return bebidaCadastroVM;
    }
    private static void validateIdPedidoIsNullEntityToVM(Bebida bebida, BebidaCadastroVM bebidaCadastroVM) {
        if (bebida.getIdentificacaoPedido() != null) {
            bebidaCadastroVM.setIdPedidoVM(bebida.getIdentificacaoPedido());
        }
    }
}
