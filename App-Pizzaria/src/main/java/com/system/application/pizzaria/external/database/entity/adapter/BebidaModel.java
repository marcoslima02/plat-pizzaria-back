package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.external.database.entity.BebidaModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BebidaModelAdapter {

    public static Bebida modelToEntity(BebidaModel bebidaModel) throws BebidaException {
        Bebida bebida = new Bebida();
        try {
            bebida.setIdBebida(bebidaModel.getIdBebidaModel());
            bebida.setNomeBebida(bebidaModel.getNomeBebidaModel());
            bebida.setQuantidadeBebida(bebidaModel.getQuantidadeBebidaModel());
            bebida.setPrecoBebida(bebidaModel.getPrecoBebidaModel());

            return bebida;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de BebidaModel para Bebida");
            throw new BebidaException(ErrorType.VALIDATIONS, "Adapter modelToEntity Bebida is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static BebidaModel entityToModel(Bebida bebida) throws BebidaException {
        try {
            BebidaModel bebidaModel = new BebidaModel();
            bebidaModel.setIdBebidaModel(bebida.getIdBebida());
            bebidaModel.setNomeBebidaModel(bebida.getNomeBebida());
            bebidaModel.setQuantidadeBebidaModel(bebida.getQuantidadeBebida());
            bebidaModel.setPrecoBebidaModel(bebida.getPrecoBebida());

            return bebidaModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Bebida para BebidaModel");
            throw new BebidaException(ErrorType.VALIDATIONS, "Adapter entityToModel Bebida is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<BebidaModel> entityListToModelList(List<Bebida> bebidaList) {
        List<BebidaModel> bebidaModelList = new ArrayList<>();
        bebidaList.forEach(bebida -> {
            try {
                bebidaModelList.add(entityToModel(bebida));
            } catch (BebidaException e) {
                e.printStackTrace();
            }
        });
        return bebidaModelList;
    }

    public static List<Bebida> modelListToEntityList(List<BebidaModel>bebidaModelList) {
        List<Bebida> bebidaList = new ArrayList<>();
        bebidaModelList.forEach(bebidaModel -> {
            try {
                bebidaList.add(modelToEntity(bebidaModel));
            } catch (BebidaException e) {
                e.printStackTrace();
            }
        });
        return bebidaList;
    }

}