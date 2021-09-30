package com.system.application.pizzaria.endpoint;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.usecase.endereco.GetAllEndereco;
import com.system.application.pizzaria.usecase.endereco.GetEnderecoById;
import com.system.application.pizzaria.viewmodel.EnderecoVM;
import com.system.application.pizzaria.viewmodel.adapter.EnderecoVMAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/endereco", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController {

    @Autowired
    private GetAllEndereco getAllEndereco;

    @Autowired
    private GetEnderecoById getEnderecoById;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EnderecoVM>> getAllEnderecos() {
        List<Endereco> listaEnderecosEntity = getAllEndereco.getAllEnderecos();
        List<EnderecoVM> listaEnderecoVM = EnderecoVMAdapter.entityListToEntityList(listaEnderecosEntity);
        return ResponseEntity.ok().body(listaEnderecoVM);
    }

    @GetMapping("/{idEndereco}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EnderecoVM> getEnderecoById(@PathVariable Integer idEndereco) throws EnderecoException {
        Endereco enderecoEntity = getEnderecoById.getEnderecoById(idEndereco);
        EnderecoVM enderecoVM = EnderecoVMAdapter.entityToViewModel(enderecoEntity);
        return ResponseEntity.ok().body(enderecoVM);
    }
}
