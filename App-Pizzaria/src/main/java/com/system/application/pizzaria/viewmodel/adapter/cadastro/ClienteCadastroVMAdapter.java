package com.system.application.pizzaria.viewmodel.adapter.cadastro;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.cadastro.ClienteCadastroVM;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class ClienteCadastroVMAdapter {

    public static Cliente viewModelToEntity(ClienteCadastroVM clienteCadastroVM) throws ClienteException {
        Cliente cliente = new Cliente();
        try {
            cliente.setNome(clienteCadastroVM.getNomeVM());
            cliente.setCpf(clienteCadastroVM.getCpfVM());
            cliente.setApelido(clienteCadastroVM.getApelidoVM());
            cliente.setSenha(clienteCadastroVM.getSenhaVM());
            cliente.setEmailCliente(clienteCadastroVM.getEmailVM());
            cliente.setTelefone(clienteCadastroVM.getTelefoneVM());
            if(cliente.getApelido().isEmpty()){
                cliente.setApelido("");
            }
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de ClienteCadastroVM para Cliente");
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return cliente;
    }

    public static ClienteCadastroVM entityToViewModel(Cliente cliente) throws ClienteException {
        ClienteCadastroVM clienteCadastroVM = new ClienteCadastroVM();
        try {
            clienteCadastroVM.setNomeVM(cliente.getNome());
            clienteCadastroVM.setCpfVM(cliente.getCpf());
            clienteCadastroVM.setApelidoVM(cliente.getApelido());
            clienteCadastroVM.setSenhaVM(cliente.getSenha());
            clienteCadastroVM.setEmailVM(cliente.getEmailCliente());
            clienteCadastroVM.setTelefoneVM(cliente.getTelefone());
            clienteCadastroVM.setApelidoVM(cliente.getApelido());
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Cliente para ClienteCadastroVM");
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return clienteCadastroVM;
    }
}
