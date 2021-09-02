package com.system.application.pizzaria.endpoint;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @GetMapping
    public Map<String, String> getListaUsuarios(){
        Map<String, String> listaAlunos = new HashMap<>();
        listaAlunos.put("Nome1:", "Erik");
        listaAlunos.put("Nome2:", "Luan");
        listaAlunos.put("Nome3", "Sarina");
        listaAlunos.put("Nome4", "Marcos");
        listaAlunos.put("Nome5", "Marcio");
        return listaAlunos;
    }
}
