package com.system.application.pizzaria.viewmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UserVM {

    private Integer idUserVM;
    private String nomeVM;
    private String cpfVM;
    private String apelidoVM;
    private String senhaVM;
    private String telefoneVM;

}
