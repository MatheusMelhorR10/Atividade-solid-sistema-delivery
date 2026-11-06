package com.delivery.payment;

public class PagamentoCartao implements MetodoPagamento {
    @Override
    public void processar(double valor) {
        System.out.println("Processando pagamento de R$ " + valor + " via Cartão.");
    }
}
