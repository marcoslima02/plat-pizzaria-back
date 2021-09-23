package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.viewmodel.EnderecoVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnderecoVMAdapter {

    public static EnderecoVM entityToViewModel(Endereco endereco) throws EnderecoException {
        try {
            EnderecoVM enderecoVM = new EnderecoVM();
            enderecoVM.setIdEnderecoVM(endereco.getIdEndereco());
            enderecoVM.setCepEnderecoVM(endereco.getCepEndereco());
            enderecoVM.setRuaEnderecoVM(endereco.getRuaEndereco());
            enderecoVM.setCidadeEnderecoVM(endereco.getCidadeEndereco());
            enderecoVM.setNumeroEnderecoVM(endereco.getNumeroEndereco());
            enderecoVM.setBairroEnderecoVM(endereco.getBairroEndereco());
            enderecoVM.setComplementoEnderecoVM(endereco.getComplementoEndereco());
            return enderecoVM;
        } catch (Exception e) {
            throw new EnderecoException(ErrorType.VALIDATIONS, "Adapter entityToVM Endereco is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Endereco viewModelToEntity(EnderecoVM enderecoVM) throws EnderecoException {
        try{
            Endereco endereco = new Endereco();
            endereco.setIdEndereco(enderecoVM.getIdEnderecoVM());
            endereco.setCepEndereco(enderecoVM.getCepEnderecoVM());
            endereco.setRuaEndereco(enderecoVM.getRuaEnderecoVM());
            endereco.setCidadeEndereco(enderecoVM.getCidadeEnderecoVM());
            endereco.setNumeroEndereco(enderecoVM.getNumeroEnderecoVM());
            endereco.setBairroEndereco(enderecoVM.getBairroEnderecoVM());
            endereco.setComplementoEndereco(enderecoVM.getComplementoEnderecoVM());
            return endereco;
        }catch (Exception e){
            throw new EnderecoException(ErrorType.VALIDATIONS, "Adapter VMToEntity Endereco is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<Endereco> viewModelListToEntityList(List<EnderecoVM> enderecoVMList){
        List<Endereco> enderecoList = new ArrayList<>();
        enderecoVMList.forEach(enderecoVM -> {
            try {
                enderecoList.add(viewModelToEntity(enderecoVM));
            } catch (EnderecoException e) {
                e.printStackTrace();
            }
        });
        return enderecoList;
    }

    public static List<EnderecoVM> entityListToEntityList(List<Endereco> enderecoList){
        List<EnderecoVM> enderecoVMList = new ArrayList<>();
        enderecoList.forEach(endereco -> {
            try {
                enderecoVMList.add(entityToViewModel(endereco));
            } catch (EnderecoException e) {
                e.printStackTrace();
            }
        });
        return enderecoVMList;
    }
}
