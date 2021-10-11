package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.external.database.entity.ClienteModel;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteModelAdapter {

    public static Cliente modelToEntity(ClienteModel clienteModel) throws ClienteException {
        Cliente cliente = new Cliente();
        List<Endereco> enderecoList = new ArrayList<>();
        try {
            cliente.setIdCliente(clienteModel.getIdClienteModel());
            cliente.setNome(clienteModel.getNomeModel());
            cliente.setCpf(clienteModel.getCpfModel());
            cliente.setApelido(clienteModel.getApelidoModel());
            cliente.setSenha(clienteModel.getSenhaModel());
            cliente.setTelefone(clienteModel.getTelefoneModel());
            clienteModel.getListaEnderecoModelClienteModel().forEach(enderecoModel -> {
                try {
                    enderecoList
                            .add(EnderecoModelAdapter.modelToEntity(enderecoModel));
                } catch (EnderecoException e) {
                    e.printStackTrace();
                }
            });
            cliente.setListaEnderecoCliente(enderecoList);
            //TODO: Converter PedidoModel para Pedido
            //cliente.setPedidoCliente(clienteModel.getPedidoModelClienteModel());

            return cliente;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de ClienteModel para Cliente");
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter modelToEntity Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static ClienteModel entityToModel(Cliente cliente) throws ClienteException {
        ClienteModel clienteModel = new ClienteModel();
        List<EnderecoModel> enderecoModelList = new ArrayList<>();

        try {
            clienteModel.setIdClienteModel(cliente.getIdCliente());
            clienteModel.setNomeModel(cliente.getNome());
            clienteModel.setCpfModel(cliente.getCpf());
            clienteModel.setApelidoModel(cliente.getApelido());
            clienteModel.setSenhaModel(cliente.getSenha());
            clienteModel.setTelefoneModel(cliente.getTelefone());
            cliente.getListaEnderecoCliente().forEach(endereco -> {
                try {
                    enderecoModelList
                            .add(EnderecoModelAdapter.entityToModel(endereco));
                } catch (EnderecoException e) {
                    e.printStackTrace();
                }
            });
            clienteModel.setListaEnderecoModelClienteModel(enderecoModelList);

            //TODO: Converter Pedido para PedidoModel
            //clienteModel.setPedidoCliente(cliente.getPedidoModelClienteModel());

            return clienteModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Cliente para ClienteModel");
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter entityToModel Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<ClienteModel> entityListToModelList(List<Cliente> clienteList) {
        List<ClienteModel> clienteModelList = new ArrayList<>();
        clienteList.forEach(endereco -> {
            try {
                clienteModelList.add(entityToModel(endereco));
            } catch (ClienteException e) {
                e.printStackTrace();
            }
        });
        return clienteModelList;
    }

    public static List<Cliente> modelListToEntityList(List<ClienteModel> clienteModelList) {
        List<Cliente> clienteList = new ArrayList<>();
        clienteModelList.forEach(enderecoModel -> {
            try {
                clienteList.add(modelToEntity(enderecoModel));
            } catch (ClienteException e) {
                e.printStackTrace();
            }
        });
        return clienteList;
    }
}
