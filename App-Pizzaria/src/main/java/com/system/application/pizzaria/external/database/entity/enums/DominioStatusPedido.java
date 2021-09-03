package com.system.application.pizzaria.external.database.entity.enums;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TB_STATUS_PEDIDO")
public class DominioStatusPedido {

    @Id
    @Column(name = "COD_STATUS_PEDIDO", nullable = false, columnDefinition = "SMALLINT")
    private Integer codigo;

    @Column(name = "DES_STATUS_PEDIDO", nullable = false, length = 100, columnDefinition = "VARCHAR(100)")
    private String descricao;
}
