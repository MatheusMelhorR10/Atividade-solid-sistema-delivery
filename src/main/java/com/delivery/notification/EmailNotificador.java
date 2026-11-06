package com.delivery.notification;

public class EmailNotificador implements Notificador {
    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("[E-mail] " + mensagem);
    }
}
