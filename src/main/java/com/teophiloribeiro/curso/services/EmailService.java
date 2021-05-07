package com.teophiloribeiro.curso.services;

import com.teophiloribeiro.curso.domain.Pedido;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);
}
