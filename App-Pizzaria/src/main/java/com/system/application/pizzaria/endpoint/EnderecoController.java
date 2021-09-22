package com.system.application.pizzaria.endpoint;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.usecase.GetAllEndereco;
import com.system.application.pizzaria.viewmodel.EnderecoVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController {
    @Autowired
    private GetAllEndereco getAllEndereco;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EnderecoVM>> getAllEnderecos(){
        List<Endereco> listaEnderecosEntity = getAllEndereco.execute();
        List<EnderecoVM> listaEnderecoVM = EnderecoVM.converter(listaEnderecosEntity);
        return ResponseEntity.ok().body(listaEnderecoVM);
    }
}
