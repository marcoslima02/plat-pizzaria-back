package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pagamento;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.exception.PagamentoException;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.external.database.entity.IngredienteModel;
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
            ConfigUtils.logger.warning("Error ao fazer adapter de IngredienteModel para Ingrediente");
            throw new PagamentoException(ErrorType.VALIDATIONS, "Adapter modelToEntity Ingrediente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static IngredienteModel entityToModel(Ingrediente ingrediente) throws IngredienteException {
        try {
            IngredienteModel ingredienteModel = new IngredienteModel();
            ingredienteModel.setIdIngredienteModel(ingrediente.getIdIngrediente());
            ingredienteModel.setNomeIngredienteModel(ingrediente.getNomeIngrediente());
            ingredienteModel.setQuantidadeIngredienteModel(ingrediente.getQuantidadeIngrediente());
            ingredienteModel.setPrecoIngredienteModel(ingrediente.getPrecoIngrediente());
            return ingredienteModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Ingrediente para IngredienteModel");
            throw new IngredienteException(ErrorType.VALIDATIONS, "Adapter entityToModel Ingrediente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<Ingrediente> modelListToEntityList(List<IngredienteModel> ingredienteModelList) {
        List<Ingrediente> ingredienteList = new ArrayList<>();
        ingredienteModelList.forEach(ingrediente -> {
            try {
                ingredienteList.add(modelToEntity(ingrediente));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
        return ingredienteList;
    }

    public static List<EnderecoModel> entityListToModelList(List<Endereco> enderecoList) {
        List<EnderecoModel> enderecoModelList = new ArrayList<>();
        enderecoList.forEach(endereco -> {
            try {
                enderecoModelList.add(entityToModel(endereco));
            } catch (EnderecoException e) {
                e.printStackTrace();
            }
        });
        return enderecoModelList;
    }

}
