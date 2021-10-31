package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.exception.PedidoException;
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
            cliente.setEmailCliente(clienteVM.getEmailClienteVM());
            cliente.setTelefone(clienteVM.getTelefoneVM());
            validateIsNullVMToEntity(clienteVM, enderecoList);
            cliente.setListaEnderecoCliente(enderecoList);
            if (clienteVM.getPedidoVMClienteVM() != null) {
                cliente.setPedidoCliente(PedidoVMAdapter.viewModelToEntity(clienteVM.getPedidoVMClienteVM()));
            }
            return cliente;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de ClienteVM para Cliente");
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validateIsNullVMToEntity(ClienteVM clienteVM, List<Endereco> enderecoList) {
        if (clienteVM.getListaEnderecoVMClienteVM() != null) {
            percorreListaEnderecoVMToEntity(clienteVM, enderecoList);
        }
    }

    private static void percorreListaEnderecoVMToEntity(ClienteVM clienteVM, List<Endereco> enderecoList) {
        clienteVM.getListaEnderecoVMClienteVM().forEach(enderecoVM -> {
            try {
                enderecoList.add(EnderecoVMAdapter.viewModelToEntity(enderecoVM));
            } catch (EnderecoException e) {
                e.printStackTrace();
            }
        });
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
            clienteVM.setEmailClienteVM(clienteVM.getEmailClienteVM());
            clienteVM.setTelefoneVM(cliente.getTelefone());
            validateIsNullEntityToVM(cliente, enderecoVMList);
            clienteVM.setListaEnderecoVMClienteVM(enderecoVMList);
            validatePedidoIsNUll(cliente, clienteVM);
            return clienteVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Cliente para ClienteVM");
            throw new ClienteException(ErrorType.VALIDATIONS, "Adapter entityToViewModel Cliente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validatePedidoIsNUll(Cliente cliente, ClienteVM clienteVM) throws PedidoException {
        if(cliente.getPedidoCliente() != null){
            clienteVM.setPedidoVMClienteVM(PedidoVMAdapter.entityToViewModel(cliente.getPedidoCliente()));
        }
    }

    private static void validateIsNullEntityToVM(Cliente cliente, List<EnderecoVM> enderecoVMList) {
        if (cliente.getListaEnderecoCliente() != null) {
            percorreListaEnderecoEntityToVM(cliente, enderecoVMList);
        }
    }

    private static void percorreListaEnderecoEntityToVM(Cliente cliente, List<EnderecoVM> enderecoVMList) {
        cliente.getListaEnderecoCliente().forEach(endereco -> {
            try {
                enderecoVMList
                        .add(EnderecoVMAdapter.entityToViewModel(endereco));
            } catch (EnderecoException e) {
                e.printStackTrace();
            }
        });
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
