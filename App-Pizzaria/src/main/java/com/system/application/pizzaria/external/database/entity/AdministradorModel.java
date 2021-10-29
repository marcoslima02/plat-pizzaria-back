package com.system.application.pizzaria.external.database.entity;

import com.system.application.pizzaria.entity.Pagamento;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_ADMINISTRADOR")
public class AdministradorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idAdministradorModel;

    @Column(name = "NOME", nullable = false, columnDefinition = "VARCHAR(100)")
    private String statusPedido;

    @OneToOne
    private Pagamento pagamentoAdministradorModel;
}
