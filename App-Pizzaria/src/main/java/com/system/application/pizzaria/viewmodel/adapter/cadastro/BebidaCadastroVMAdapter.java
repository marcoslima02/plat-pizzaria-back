package com.system.application.pizzaria.viewmodel.adapter.cadastro;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.cadastro.BebidaCadastroVM;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.Date;

public class BebidaCadastroVMAdapter {


    public static Bebida viewModelToEntity(BebidaCadastroVM bebidaCadastroVM) throws BebidaException {
        Bebida bebida = new Bebida();
        try {
            bebida.setNomeBebida(bebidaCadastroVM.getNomeBebidaVM());
            bebida.setQuantidadeBebida(bebidaCadastroVM.getQuantidadeBebidaVM());
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de BebidaCadastroVM para Bebida");
            throw new BebidaException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Bebida is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return bebida;
    }

    public static BebidaCadastroVM entityToViewModel(Bebida bebida) throws BebidaException {
        BebidaCadastroVM bebidaCadastroVM = new BebidaCadastroVM();
        try {
            bebidaCadastroVM.setNomeBebidaVM(bebida.getNomeBebida());
            bebidaCadastroVM.setQuantidadeBebidaVM(bebida.getQuantidadeBebida());
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Bebida para BebidaCadastroVM");
            throw new BebidaException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Bebida is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return bebidaCadastroVM;
    }
}
