package com.delivery.service;

import com.delivery.model.Pedido;
import com.delivery.model.Produto;

public class PedidoPrinter {
    public void exibir(Pedido pedido) {
        System.out.println("=== Detalhes do Pedido: " + pedido.getId() + " ===");
        for (Produto p : pedido.getProdutos()) {
            System.out.println("- " + p.getNome() + ": R$ " + p.getPreco());
        }
        System.out.println("Total: R$ " + pedido.getValorTotal());
    }
}
