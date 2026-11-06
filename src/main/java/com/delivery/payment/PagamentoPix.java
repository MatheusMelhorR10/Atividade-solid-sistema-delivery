package com.delivery.payment;

public class PagamentoPix implements MetodoPagamento {
    @Override
    public void processar(double valor) {
        System.out.println("Gerando QR Code PIX para o valor de R$ " + valor);
    }
}
