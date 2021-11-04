package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Pagamento;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.PagamentoException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.PagamentoVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PagamentoVMAdapter {

    public static PagamentoVM entityToViewModel(Pagamento pagamento) throws PagamentoException {
        try {
            PagamentoVM pagamentoVM = new PagamentoVM();
            pagamentoVM.setIdPagamentoVM(pagamento.getIdPagamento());
            pagamentoVM.setFuncionarioPagamentoVM(pagamento.getFuncionarioPagamento());
            pagamentoVM.setSalarioPagamentoVM(pagamento.getSalarioPagamento());
            return pagamentoVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Pagamento para PagamentoVM");
            throw new PagamentoException(ErrorType.VALIDATIONS, "Adapter entityToViewModel Pagamento is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Pagamento viewModelToEntity(PagamentoVM pagamentoVM) throws PagamentoException {
        try{
            Pagamento pagamento = new Pagamento();
            pagamento.setIdPagamento(pagamentoVM.getIdPagamentoVM());
            pagamento.setFuncionarioPagamento(pagamentoVM.getFuncionarioPagamentoVM());
            pagamento.setSalarioPagamento(pagamentoVM.getSalarioPagamentoVM());
            return pagamento;
        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de PagamentoVM para Pagamento");
            throw new PagamentoException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pagamento is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<Pagamento> viewModelListToEntityList(List<PagamentoVM> pagamentoVMList){
        List<Pagamento> pagamentoList = new ArrayList<>();
        pagamentoVMList.forEach(pagamentoVM -> {
            try {
                pagamentoList.add(viewModelToEntity(pagamentoVM));
            } catch (PagamentoException e) {
                e.printStackTrace();
            }
        });
        return pagamentoList;
    }

    public static List<PagamentoVM> entityListToViewModelList(List<Pagamento> pagamentoList) {
        List<PagamentoVM> pagamentoVMList = new ArrayList<>();
        pagamentoList.forEach(pagamento -> {
            try {
                pagamentoVMList.add(entityToViewModel(pagamento));
            } catch (PagamentoException e) {
                e.printStackTrace();
            }
        });
        return pagamentoVMList;
    }

}
