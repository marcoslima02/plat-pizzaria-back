package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.ClienteVM;
import com.system.application.pizzaria.viewmodel.EnderecoVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteVMAdapter {

    public static Cliente viewModelToEntity(ClienteVM clienteVM) throws ClienteException {
        Cliente cliente = new Cliente();
        List<Endereco> enderecoList = new ArrayList<>();
        try {
            cliente.setIdCliente(clienteVM.getIdClienteVM());
            cliente.setNome(clienteVM.getNomeVM());
            cliente.setCpf(clienteVM.getCpfVM());
            cliente.setApelido(clienteVM.getApelidoVM());
            cliente.setSenha(clienteVM.getSenhaVM());
            cliente.setTelefone(clienteVM.getTelefoneVM());
            clienteVM.getListaEnderecoVMClienteVM().forEach(enderecoVM -> {
                try {
                    enderecoList.add(EnderecoVMAdapter.viewModelToEntity(enderecoVM));
                } catch (EnderecoException e) {
                    e.printStackTrace();
                }
            });
            cliente.setListaEnderecoCliente(enderecoList);
            //TODO: Converter PedidoVM para Pedido
            //cliente.setPedidoCliente(clienteVM.getPedidoVMClienteVM());

            return cliente;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de ClienteVM para Cliente");
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static ClienteVM entityToViewModel(Cliente cliente) throws ClienteException {
        ClienteVM clienteVM = new ClienteVM();
        List<EnderecoVM> enderecoVMList = new ArrayList<>();

        try {
            clienteVM.setIdClienteVM(cliente.getIdCliente());
            clienteVM.setNomeVM(cliente.getNome());
            clienteVM.setCpfVM(cliente.getCpf());
            clienteVM.setApelidoVM(cliente.getApelido());
            clienteVM.setSenhaVM(cliente.getSenha());
            clienteVM.setTelefoneVM(cliente.getTelefone());
            cliente.getListaEnderecoCliente().forEach(endereco -> {
                try {
                    enderecoVMList
                            .add(EnderecoVMAdapter.entityToViewModel(endereco));
                } catch (EnderecoException e) {
                    e.printStackTrace();
                }
            });
            clienteVM.setListaEnderecoVMClienteVM(enderecoVMList);

            //TODO: Converter Pedido para PedidoVM
            //clienteVM.setPedidoCliente(cliente.getPedidoVMClienteVM());

            return clienteVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Cliente para ClienteVM");
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter entityToViewModel Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<ClienteVM> entityListToVMList(List<Cliente> clienteList) {
        List<ClienteVM> clienteVMList = new ArrayList<>();
        clienteList.forEach(endereco -> {
            try {
                clienteVMList.add(entityToViewModel(endereco));
            } catch (ClienteException e) {
                e.printStackTrace();
            }
        });
        return clienteVMList;
    }

    public static List<Cliente> VMListToEntityList(List<ClienteVM> clienteVMList) {
        List<Cliente> clienteList = new ArrayList<>();
        clienteVMList.forEach(enderecoVM -> {
            try {
                clienteList.add(viewModelToEntity(enderecoVM));
            } catch (ClienteException e) {
                e.printStackTrace();
            }
        });
        return clienteList;
    }
}
