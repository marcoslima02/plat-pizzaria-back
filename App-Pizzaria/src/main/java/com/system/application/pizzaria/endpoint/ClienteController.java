package com.system.application.pizzaria.endpoint;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.usecase.cliente.GetAllCliente;
import com.system.application.pizzaria.usecase.cliente.ValidateClienteLogin;
import com.system.application.pizzaria.viewmodel.UserLoginVM;
import com.system.application.pizzaria.viewmodel.ClienteVM;
import com.system.application.pizzaria.viewmodel.adapter.ClienteVMAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    @Autowired
    private GetAllCliente getAllCliente;

    @Autowired
    private ValidateClienteLogin validateClienteLogin;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ClienteVM>> getAllClientesController() throws ClienteException {
        List<Cliente> allClientes = getAllCliente.getAllClientes();
        List<ClienteVM> clienteVMS = ClienteVMAdapter.entityListToVMList(allClientes);
        return ResponseEntity.status(200).body(clienteVMS);
    }

    @PostMapping
    public ResponseEntity<ClienteVM> getValideClienteLogin(@RequestBody final UserLoginVM clienteLogin) throws ClienteException {
        Cliente cliente = validateClienteLogin.validateClienteLogin(clienteLogin.getUserCpfLogin(), clienteLogin.getUserSenhaLogin());
        ClienteVM clienteVM = ClienteVMAdapter.entityToViewModel(cliente);
        return ResponseEntity.status(200).body(clienteVM);
    }
}
