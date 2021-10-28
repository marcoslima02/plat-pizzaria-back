package com.system.application.pizzaria.external.database;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.external.ClientePersistenceDataBase;
import com.system.application.pizzaria.external.database.entity.ClienteModel;
import com.system.application.pizzaria.external.database.entity.adapter.ClienteCadastroModelAdapter;
import com.system.application.pizzaria.external.database.entity.adapter.ClienteModelAdapter;
import com.system.application.pizzaria.external.database.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ClientePersistenceDataBaseImpl implements ClientePersistenceDataBase {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() throws ClienteException {
        List<ClienteModel> clienteModelList = clienteRepository.findAll();
        return ClienteModelAdapter.modelListToEntityList(clienteModelList);
    }

    @Override
    public Cliente getClienteById(Integer idCliente) throws ClienteException {
        ClienteModel clienteModel = clienteRepository.getById(idCliente);
        return ClienteModelAdapter.modelToEntity(clienteModel);
    }

    @Override
    public Cliente getClienteByCPF(String cpfCliente) throws ClienteException {
        ClienteModel clienteModel = clienteRepository.findByCpfModel(cpfCliente);
        return ClienteModelAdapter.modelToEntity(clienteModel);
    }

    @Override
    public Cliente getValidateClienteLogin(String cpfCliente, String senhaCliente) throws ClienteException {
        ClienteModel clienteModel = null;
        try {
            if (clienteRepository.existsByCpfModel(cpfCliente) && clienteRepository.existsBySenhaModel(senhaCliente)) {
                clienteModel = clienteRepository.findByCpfModel(cpfCliente);
            }
            return ClienteModelAdapter.modelToEntity(clienteModel);
        } catch (Exception e) {
            throw new ClienteException(ErrorType.DATA_BASE_NOT_FOUND, "CPF ou SENHA invalida", new Date(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Cliente saveCliente(Cliente cliente) throws ClienteException {
        ClienteModel clienteModel = ClienteCadastroModelAdapter.entityToModel(cliente);
        try {
            clienteRepository.save(clienteModel);
            return ClienteModelAdapter.modelToEntity(clienteModel);
        } catch (Exception e) {
            throw new ClienteException(ErrorType.ERROR_DATABASE_SAVE, "Erro ao salvar Cliente", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Boolean getvalidateCPF(String cpfCliente) throws ClienteException {
        return clienteRepository.existsByCpfModel(cpfCliente);
    }
}
