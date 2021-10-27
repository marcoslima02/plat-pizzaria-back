package com.system.application.pizzaria.external;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.exception.ClienteException;

import java.util.List;

public interface ClientePersistenceDataBase {

    List<Cliente> getAllClientes() throws ClienteException;

    Cliente getClienteById(Integer idCliente) throws ClienteException;

    Cliente getClienteByCPF(String cpfCliente) throws ClienteException;

    Cliente getValidateClienteLogin(String cpfCliente, String senhaCliente) throws ClienteException;

    Cliente saveCliente(Cliente cliente) throws ClienteException;

    Boolean getvalidateCPF(String cpfCliente) throws ClienteException;

}
