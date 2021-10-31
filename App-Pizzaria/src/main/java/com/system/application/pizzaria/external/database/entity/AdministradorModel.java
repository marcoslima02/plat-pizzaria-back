package com.system.application.pizzaria.external.database.entity;

import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "TB_ADMINISTRADOR")
public class AdministradorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idAdministradorModel;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedidoAdministrador = StatusPedido.CONCLUIDO;

    @Column(name = "PAGAMENTOS")
    @OneToMany(mappedBy = "administradorModel")
    private List<PagamentoModel> listaPagamentoModelAdministradorModel;

}
