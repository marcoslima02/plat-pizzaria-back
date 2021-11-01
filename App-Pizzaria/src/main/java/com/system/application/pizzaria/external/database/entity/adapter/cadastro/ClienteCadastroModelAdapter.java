package com.system.application.pizzaria.external.database.entity.adapter.cadastro;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.external.database.entity.ClienteModel;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteCadastroModelAdapter {
    public static Cliente modelToEntity(ClienteModel clienteModel) throws ClienteException {
        Cliente cliente = new Cliente();
        List<Endereco> listaEndereco = new ArrayList<>();
        try {
            cliente.setNome(clienteModel.getNomeModel());
            cliente.setCpf(clienteModel.getCpfModel());
            cliente.setApelido(clienteModel.getApelidoModel());
            cliente.setSenha(clienteModel.getSenhaModel());
            cliente.setEmailCliente(clienteModel.getEmailClienteModel());
            cliente.setTelefone(clienteModel.getTelefoneModel());
            cliente.setListaEnderecoCliente(listaEndereco);
            return cliente;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de ClienteCadastroModel para ClienteCadastro");
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter modelToEntity Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static ClienteModel entityToModel(Cliente cliente) throws ClienteException {
        ClienteModel clienteModel = new ClienteModel();
        List<EnderecoModel> listaEnderecoModel = new ArrayList<>();
        try {
            clienteModel.setNomeModel(cliente.getNome());
            clienteModel.setCpfModel(cliente.getCpf());
            clienteModel.setApelidoModel(cliente.getApelido());
            clienteModel.setEmailClienteModel(cliente.getEmailCliente());
            clienteModel.setSenhaModel(cliente.getSenha());
            clienteModel.setTelefoneModel(cliente.getTelefone());
            clienteModel.setListaEnderecoModelClienteModel(listaEnderecoModel);
            return clienteModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de ClienteCadastro para ClienteCadastroModel");
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter entityToModel Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
