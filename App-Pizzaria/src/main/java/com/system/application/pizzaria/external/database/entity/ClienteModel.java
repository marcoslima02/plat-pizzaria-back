package com.system.application.pizzaria.external.database.entity;

import javax.persistence.*;
@Entity
@Table(name = "TB_CLIENTE")

public class ClienteModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Integer idClienteModel;


    }
