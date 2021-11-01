package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.*;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.AdministradorException;
import com.system.application.pizzaria.exception.CozinheiroException;
import com.system.application.pizzaria.exception.PagamentoException;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.external.database.entity.AdministradorModel;
import com.system.application.pizzaria.external.database.entity.CozinheiroModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdministradorModelAdapter {

    public static Administrador modelToEntity(AdministradorModel administradorModel) throws AdministradorException {
        Administrador administrador = new Administrador();
        List<Pagamento> pagamentoList = new ArrayList<>();

        try {
            administrador.setIdAdministrador(administradorModel.getIdAdministradorModel());
            administrador.setNome(administradorModel.getNomeModel());
            administrador.setCpf(administradorModel.getCpfModel());
            administrador.setApelido(administradorModel.getApelidoModel());
            administrador.setSenha(administradorModel.getSenhaModel());
            administrador.setTelefone(administradorModel.getTelefoneModel());
            administrador.setHorarioTrabalho(administradorModel.getHorarioTrabalhoModel());
            administrador.setSalario(administradorModel.getSalarioModel());
            administrador.setIdAdministrador(administradorModel.getIdAdministradorModel());
            validateIsExistsNUllModelToEntity(administradorModel, pagamentoList);
            administrador.setListaPagamentoAdministrador(pagamentoList);

            return administrador;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de AdministradorModel para Administrador");
            throw new AdministradorException(ErrorType.VALIDATIONS, "Adapter modelToEntity Administrador is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validateIsExistsNUllModelToEntity(AdministradorModel administradorModel, List<Pagamento> pagamentoList) {
        if(administradorModel.getListaPagamentoModelAdministradorModel() != null){
            percorreListaPagamentoModel(administradorModel, pagamentoList);
        }
    }

    private static void percorreListaPagamentoModel(AdministradorModel administradorModel, List<Pagamento> pagamentoList) {
        administradorModel.getListaPagamentoModelAdministradorModel().forEach(pagamentoModel -> {
            try {
                pagamentoList.add(PagamentoModelAdapter.modelToEntity(pagamentoModel));
            } catch (PagamentoException e) {
                e.printStackTrace();
            }
        });
    }

}


