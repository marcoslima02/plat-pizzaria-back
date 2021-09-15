package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class User {

    private Integer idUser;

    @Setter
    private String nomeUser;

    @Setter
    private String cpfUser;

    @Setter
    private String apelidoUser;

    @Setter
    private String senhaUser;

    @Setter
    private String telefoneUser;
}