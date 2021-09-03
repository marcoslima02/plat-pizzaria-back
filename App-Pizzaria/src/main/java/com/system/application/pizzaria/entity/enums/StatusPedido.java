package com.system.application.pizzaria.entity.enums;

import lombok.Getter;

@Getter
public enum StatusPedido {

    PENDENTE(1,"Pedido não finalizado corretamente"),
    AGUARDANDO(2,"Pedido recebido, mas não pago ainda e não iniciado pelo atendente"),
    PROCESSANDO(3,"Pedido recebido, iniciado pelo atendente mas não pago ainda"),
    FINALIZADO(4,"Pedido Finalizado, porém não enviado para o Cliente"),
    CONCLUIDO(5,"Pedido Concluido, produto entregue ao cliente"),
    CANCELADO(6,"Pedido Cancelado, caso o pagamento não ocorra"),
    REEMBOLSADO(7,"Pedido Reembolsado, valor devolvido ao comprador");

    private final String descricao;
    private final Integer codigo;

    StatusPedido(int code, String descricao) {
        this.codigo = code;
        this.descricao = descricao;
    }
}
