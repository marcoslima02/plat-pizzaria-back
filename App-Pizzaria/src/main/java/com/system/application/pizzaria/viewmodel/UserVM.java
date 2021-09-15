package com.system.application.pizzaria.viewmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class UserVM {

    private Integer idUserVM;

    @Setter
    private String nomeUserVM;

    @Setter
    private String cpfUserVM;

    @Setter
    private String apelidoUserVM;

    @Setter
    private String senhaUserVM;

    @Setter
    private String telefoneUserVM;
}
