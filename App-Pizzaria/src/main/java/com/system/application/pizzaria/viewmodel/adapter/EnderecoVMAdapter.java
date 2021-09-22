package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.viewmodel.EnderecoVM;

public class EnderecoVMAdapter {

    public static EnderecoVM entityToViewModel(Endereco endereco) {
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
            throw new EnderecoException(EnderecoException.ErrorType.VALIDATIONS, "Adapter entityToVM Endereco is Null");
        }
    }

    public static Endereco viewModelToEntity(EnderecoVM enderecoVM) {
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
            throw new EnderecoException(EnderecoException.ErrorType.VALIDATIONS, "Adapter VMToEntity Endereco is Null");
        }
    }
}
