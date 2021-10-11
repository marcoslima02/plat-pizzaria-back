package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.external.database.entity.adapter.EnderecoModelAdapter;
import com.system.application.pizzaria.viewmodel.ClienteVM;
import org.springframework.http.HttpStatus;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteVMAdapter {

    public static ClienteVM entityToViewModel(Cliente cliente) throws ClienteException {
        ClienteVM clienteVM = new ClienteVM();
        //TODO: Criar a lista do Tipo EnderecoVM
        try {

            clienteVM.setIdClienteVM(cliente.getIdCliente());
            clienteVM.setNomeVM(cliente.getNome());
            clienteVM.setCpfVM(cliente.getCpf());
            clienteVM.setApelidoVM(cliente.getApelido());
            clienteVM.setSenhaVM(cliente.getSenha());
            clienteVM.setTelefoneVM(cliente.getTelefone());
            //TODO: Converter PedidoVM para Pedido
            //cliente.setPedidoCliente(clienteVM.getPedidoVMClienteVM());
            clienteVM.getListaEnderecoVMClienteVM().forEach(enderecoModel -> {
                try {
                    //TODO: Substiuir esse método para chamar a variavel lista
                    cliente.getListaEnderecoCliente().add(EnderecoVMAdapter.viewModelToEntity(enderecoModel));
                } catch (EnderecoException e) {
                    e.printStackTrace();
                }
            });
            //TODO: Setar o atributo Lista de endereco do Cliente
            return clienteVM;
        } catch (Exception e) {
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter entityToVM Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Cliente viewModelToEntity(ClienteVM clienteVM) throws ClienteException {
        try{
            Cliente cliente = new Cliente();
            cliente.setIdCliente(clienteVM.getIdClienteVM());
            cliente.setNome(clienteVM.getNomeVM());
            cliente.setCpf(clienteVM.getCpfVM());
            cliente.setApelido(clienteVM.getApelidoVM());
            cliente.setSenha(clienteVM.getSenhaVM());
            cliente.setTelefone(clienteVM.getTelefoneVM());
            //TODO: Converter PedidoVM para Pedido
            //cliente.setPedidoCliente(clienteVM.getPedidoVMClienteVM());
            clienteVM.getListaEnderecoVMClienteVM().forEach(enderecoModel -> {
                try {
                    cliente.getListaEnderecoCliente()
                            .add(EnderecoVMAdapter.viewModelToEntity(enderecoModel));
                } catch (EnderecoException e) {
                    e.printStackTrace();
                }
            });
            return cliente;
        }catch (Exception e){
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter VMToEntity Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<Cliente> viewModelListToEntityList(List<ClienteVM> clienteVMList){
        List<Cliente> clienteList = new ArrayList<>();
        clienteVMList.forEach(clienteVM -> {
            try {
                clienteList.add(viewModelToEntity(clienteVM));
            } catch (ClienteException e) {
                e.printStackTrace();
            }
        });
        return clienteList;
    }

    public static List<ClienteVM> entityListToViewModelList(List<Cliente> clienteList){
        List<ClienteVM> clienteVMList = new ArrayList<>();
        clienteList.forEach(cliente -> {
            try {
                clienteVMList.add(entityToViewModel(cliente));
            } catch (ClienteException e) {
                e.printStackTrace();
            }
        });
        return clienteVMList;
    }
}
