package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Pagamento;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.PagamentoException;
import com.system.application.pizzaria.external.database.entity.PagamentoModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PagamentoModelAdapter {
    public static Pagamento modelToEntity(PagamentoModel pagamentoModel) throws PagamentoException {
        try {
            Pagamento pagamento = new Pagamento();
            pagamento.setIdPagamento(pagamentoModel.getIdPagamentoModel());
            pagamento.setFuncionarioPagamento(pagamentoModel.getFuncionarioPagamentoModel());
            pagamento.setSalarioPagamento(pagamentoModel.getSalarioPagamentoModel());
            return pagamento;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PagamentoModel para Pagamento");
            throw new PagamentoException(ErrorType.VALIDATIONS, "Adapter modelToEntity Pagamento is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static PagamentoModel entityToModel(Pagamento pagamento) throws PagamentoException {
        try {
            PagamentoModel pagamentoModel = new PagamentoModel();
            pagamentoModel.setIdPagamentoModel(pagamento.getIdPagamento());
            pagamentoModel.setFuncionarioPagamentoModel(pagamento.getFuncionarioPagamento());
            pagamentoModel.setSalarioPagamentoModel(pagamento.getSalarioPagamento());
            return pagamentoModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Pagamento para PagamentoModel");
            throw new PagamentoException(ErrorType.VALIDATIONS, "Adapter entityToModel Pagamento is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<Pagamento> modelListToEntityList(List<PagamentoModel> pagamentoModelList) {
        List<Pagamento> pagamentoList = new ArrayList<>();
        pagamentoModelList.forEach(pagamento -> {
            try {
                pagamentoList.add(modelToEntity(pagamento));
            } catch (PagamentoException e) {
                e.printStackTrace();
            }
        });
        return pagamentoList;
    }

}
