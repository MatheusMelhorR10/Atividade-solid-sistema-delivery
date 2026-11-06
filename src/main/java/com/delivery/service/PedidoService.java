package com.delivery.service;

import com.delivery.model.Pedido;
import com.delivery.notification.Notificador;
import com.delivery.payment.MetodoPagamento;

public class PedidoService {
    private Notificador notificador;
    private PedidoRepository repository;

    public PedidoService(Notificador notificador, PedidoRepository repository) {
        this.notificador = notificador;
        this.repository = repository;
    }

    public void finalizarPedido(Pedido pedido, MetodoPagamento pagamento) {
        pagamento.processar(pedido.getValorTotal());
        repository.salvar(pedido);
        notificador.enviarNotificacao("Seu pedido " + pedido.getId() + " foi confirmado!");
    }
}
