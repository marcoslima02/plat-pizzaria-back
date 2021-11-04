package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Administrador;
import com.system.application.pizzaria.entity.Pagamento;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.AdministradorException;
import com.system.application.pizzaria.exception.PagamentoException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.AdministradorVM;
import com.system.application.pizzaria.viewmodel.PagamentoVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdministradorVMAdapter {

    public static Administrador viewModelToEntity(AdministradorVM administradorVM) throws AdministradorException {
    Administrador administrador = new Administrador();
    List<Pagamento> pagamentoList = new ArrayList<>();

    try {
        administrador.setIdAdministrador(administradorVM.getIdAdministradorVM());
        administrador.setNome(administradorVM.getNomeVM());
        administrador.setCpf(administradorVM.getCpfVM());
        administrador.setApelido(administradorVM.getApelidoVM());
        administrador.setSenha(administradorVM.getSenhaVM());
        administrador.setTelefone(administradorVM.getTelefoneVM());
        administrador.setHorarioTrabalho(administradorVM.getHorarioTrabalhoVM());
        administrador.setSalario(administradorVM.getSalarioVM());
        administrador.setIdAdministrador(administradorVM.getIdAdministradorVM());
        validateIsExistsNUllVMToEntity(administradorVM, pagamentoList);
        administrador.setListaPagamentoAdministrador(pagamentoList);

        return administrador;
    } catch (Exception e) {
        ConfigUtils.logger.warning("Error ao fazer adapter de AdministradorVM para Administrador");
        throw new AdministradorException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Administrador is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    private static void validateIsExistsNUllVMToEntity(AdministradorVM administradorVM, List<Pagamento> pagamentoList) {
        if(administradorVM.getListaPagamentoVMAdministradorVM() != null){
            percorreListaPagamentoVM(administradorVM, pagamentoList);
        }
    }

    private static void percorreListaPagamentoVM(AdministradorVM administradorVM, List<Pagamento> pagamentoList) {
        administradorVM.getListaPagamentoVMAdministradorVM().forEach(pagamentoVM -> {
            try {
                pagamentoList.add(PagamentoVMAdapter.viewModelToEntity(pagamentoVM));
            } catch (PagamentoException e) {
                e.printStackTrace();
            }
        });
    }


    public static AdministradorVM entityToViewModel(Administrador administrador) throws AdministradorException {
        AdministradorVM administradorVM = new AdministradorVM();
        List<PagamentoVM> pagamentoVMList = new ArrayList<>();

        try {
            administradorVM.setIdAdministradorVM(administrador.getIdAdministrador());
            administradorVM.setNomeVM(administrador.getNome());
            administradorVM.setCpfVM(administrador.getCpf());
            administradorVM.setApelidoVM(administrador.getApelido());
            administradorVM.setSenhaVM(administrador.getSenha());
            administradorVM.setTelefoneVM(administrador.getTelefone());
            administradorVM.setHorarioTrabalhoVM(administrador.getHorarioTrabalho());
            administradorVM.setSalarioVM(administrador.getSalario());
            administradorVM.setIdAdministradorVM(administrador.getIdAdministrador());
            validateIsNullEntityToViewModel(administrador, pagamentoVMList);
            administradorVM.setListaPagamentoVMAdministradorVM(pagamentoVMList);
            return administradorVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Administrador para AdministradorVM");
            throw new AdministradorException(ErrorType.VALIDATIONS, "Adapter entityToViewModel Administrador is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validateIsNullEntityToViewModel(Administrador administrador, List<PagamentoVM> pagamentoVMList) {
        if(administrador.getListaPagamentoAdministrador() != null){
            percorreListaPagamentosEntity(administrador, pagamentoVMList);
        }
    }

    private static void percorreListaPagamentosEntity(Administrador administrador, List<PagamentoVM> pagamentoVMList) {
        administrador.getListaPagamentoAdministrador().forEach(pagamento -> {
            try {
                pagamentoVMList.add(PagamentoVMAdapter.entityToViewModel(pagamento));
            } catch (PagamentoException e) {
                e.printStackTrace();
            }
        });
    }

}


