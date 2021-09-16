package com.system.application.pizzaria.endpoint;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @GetMapping
    public Map<String, String> getListaUsuarios(){
        Map<String, String> listaAlunos = new HashMap<>();
        return listaAlunos;
    }
}
