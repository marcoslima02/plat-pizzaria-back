package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.external.database.entity.BebidaModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class BebidaCadastroModelAdapter {
    public static Bebida modelToEntity(BebidaModel bebidaModel) throws BebidaException {
        Bebida bebida = new Bebida();
        try {
            bebida.setIdBebida(bebidaModel.getIdBebidaModel());
            bebida.setNomeBebida(bebidaModel.getNomeBebidaModel());
            bebida.setQuantidadeBebida(bebidaModel.getQuantidadeBebidaModel());
            bebida.setPrecoBebida(bebidaModel.getPrecoBebidaModel());
            return bebida;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de BebidaCadastroModel para BebidaCadastro");
            throw new BebidaException(ErrorType.VALIDATIONS, "Adapter modelToEntity Bebida is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static BebidaModel entityToModel(Bebida bebida) throws BebidaException {
        BebidaModel bebidaModel = new BebidaModel();
        try {
            bebidaModel.setIdBebidaModel(bebida.getIdBebida());
            bebidaModel.setNomeBebidaModel(bebida.getNomeBebida());
            bebidaModel.setQuantidadeBebidaModel(bebida.getQuantidadeBebida());
            bebidaModel.setPrecoBebidaModel(bebida.getPrecoBebida());
            return bebidaModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de BebidaCadastro para BebidaCadastroModel");
            throw new BebidaException(ErrorType.VALIDATIONS, "Adapter entityToModel Bebida is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}

