package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.external.database.entity.adapter.EnderecoModelAdapter;
import com.system.application.pizzaria.viewmodel.ClienteVM;
import com.system.application.pizzaria.viewmodel.EnderecoVM;
import org.springframework.http.HttpStatus;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteVMAdapter {

    public static ClienteVM entityToViewModel(Cliente cliente) throws ClienteException {
        ClienteVM clienteVM = new ClienteVM();
        List<EnderecoVM> enderecoVMList = new ArrayList<>();
        //Criar a lista do Tipo EnderecoVM
        try {

            clienteVM.setIdClienteVM(cliente.getIdCliente());
            clienteVM.setNomeVM(cliente.getNome());
            clienteVM.setCpfVM(cliente.getCpf());
            clienteVM.setApelidoVM(cliente.getApelido());
            clienteVM.setSenhaVM(cliente.getSenha());
            clienteVM.setTelefoneVM(cliente.getTelefone());
            //Converter PedidoVM para Pedido
            //cliente.setPedidoCliente(clienteVM.getPedidoVMClienteVM());
            clienteVM.getListaEnderecoVMClienteVM().forEach(endereco -> {
                try {
                    //Substiuir esse método para chamar a variavel lista
                    enderecoVMList
                            .add(EnderecoVMAdapter.entityToViewModel(endereco));
                } catch (EnderecoException e) {
                    e.printStackTrace();
                }
            });

            clienteVM.setListaEnderecoVMClienteVM(enderecoVMList);
            //TODO: Setar o atributo Lista de endereco do Cliente
            return clienteVM;
        } catch (Exception e) {
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter entityToVM Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Cliente viewModelToEntity(ClienteVM clienteVM) throws ClienteException {
        Cliente cliente = new Cliente();
        List<EnderecoVM> enderecoVMList2 = new ArrayList<>();

        try{
            cliente.setIdCliente(clienteVM.getIdClienteVM());
            cliente.setNome(clienteVM.getNomeVM());
            cliente.setCpf(clienteVM.getCpfVM());
            cliente.setApelido(clienteVM.getApelidoVM());
            cliente.setSenha(clienteVM.getSenhaVM());
            cliente.setTelefone(clienteVM.getTelefoneVM());
            //TODO: Converter PedidoVM para Pedido
            //cliente.setPedidoCliente(clienteVM.getPedidoVMClienteVM());
            clienteVM.getListaEnderecoVMClienteVM().forEach(endereco -> {
                try {
                    enderecoVMList2
                            .add(EnderecoVMAdapter.entityToViewModel(endereco));
                } catch (EnderecoException e) {
                    e.printStackTrace();
                }
            });

            clienteVM.setListaEnderecoVMClienteVM(enderecoVMList2);
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
