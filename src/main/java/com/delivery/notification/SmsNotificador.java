package com.delivery.notification;

public class SmsNotificador implements Notificador {
    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("[SMS] " + mensagem);
    }
}
