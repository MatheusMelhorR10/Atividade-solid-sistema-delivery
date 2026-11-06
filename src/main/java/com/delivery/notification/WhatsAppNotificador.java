package com.delivery.notification;

public class WhatsAppNotificador implements Notificador {
    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("[WhatsApp] " + mensagem);
    }
}
