package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_USERS")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long idUserModel;

    @Column(name = "NOME", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nomeUserModel;

    @Column(name = "CPF", nullable = false, columnDefinition = "VARCHAR(14)")
    private String cpfUserModel;

    @Column(name = "APELIDO", columnDefinition = "VARCHAR(20)")
    private String apelidoUserModel;

    @Column(name = "SENHA", nullable = false, columnDefinition = "VARCHAR(50)")
    private String senhaUserModel;

    @Column(name = "TELEFONE", nullable = false, columnDefinition = "VARCHAR(25)")
    private String telefoneUserModel;
}
