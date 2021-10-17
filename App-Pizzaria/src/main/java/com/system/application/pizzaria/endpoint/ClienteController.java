package com.system.application.pizzaria.endpoint;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.usecase.cliente.*;
import com.system.application.pizzaria.viewmodel.ClienteCadastroVM;
import com.system.application.pizzaria.viewmodel.UserLoginVM;
import com.system.application.pizzaria.viewmodel.ClienteVM;
import com.system.application.pizzaria.viewmodel.adapter.ClienteCadastroVMAdapter;
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
    private GetClienteByCPF getClienteByCPF;

    @Autowired
    private GetClienteById getClienteById;

    @Autowired
    private ValidateClienteLogin validateClienteLogin;

    @Autowired
    private SaveCliente saveCliente;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ClienteVM>> getAllClientesController() throws ClienteException {
        List<Cliente> allClientes = getAllCliente.getAllClientes();
        List<ClienteVM> clienteVMS = ClienteVMAdapter.entityListToVMList(allClientes);
        return ResponseEntity.status(200).body(clienteVMS);
    }

    @GetMapping("/cpf/{cpfCliente}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClienteVM> getClienteByCPFController(@PathVariable String cpfCliente) throws ClienteException {
        Cliente cliente = getClienteByCPF.getClienteByCPF(cpfCliente);
        ClienteVM clienteVM = ClienteVMAdapter.entityToViewModel(cliente);
        return ResponseEntity.status(200).body(clienteVM);
    }

    @GetMapping("/id/{idCliente}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClienteVM> getClienteByCPFController(@PathVariable Integer idCliente) throws ClienteException {
        Cliente cliente = getClienteById.getClienteById(idCliente);
        ClienteVM clienteVM = ClienteVMAdapter.entityToViewModel(cliente);
        return ResponseEntity.status(200).body(clienteVM);
    }

    @PostMapping("/login")
    public ResponseEntity<ClienteVM> getValideClienteLoginController(@RequestBody final UserLoginVM clienteLogin) throws ClienteException {
        Cliente cliente = validateClienteLogin.validateClienteLogin(clienteLogin.getUserCpfLogin(), clienteLogin.getUserSenhaLogin());
        ClienteVM clienteVM = ClienteVMAdapter.entityToViewModel(cliente);
        return ResponseEntity.status(200).body(clienteVM);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<ClienteCadastroVM> saveClienteController(@RequestBody final ClienteCadastroVM clienteCadastroVM) throws ClienteException {
        Cliente cliente = ClienteCadastroVMAdapter.viewModelToEntity(clienteCadastroVM);
        ClienteCadastroVM clienteCadastroReturnDataBase = ClienteCadastroVMAdapter.entityToViewModel(saveCliente.saveCliente(cliente));
        return ResponseEntity.status(200).body(clienteCadastroReturnDataBase);
    }
}
