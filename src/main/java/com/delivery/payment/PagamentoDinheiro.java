package com.delivery.payment;

public class PagamentoDinheiro implements MetodoPagamento {
    @Override
    public void processar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " em dinheiro confirmado.");
    }
}
