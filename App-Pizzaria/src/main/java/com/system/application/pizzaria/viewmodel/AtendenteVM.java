package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.Pedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class AtendenteVM extends FuncionarioVM{
    private Integer idAtendenteVM;
    private List<PedidoVM> ListapedidoAtendente;
}
