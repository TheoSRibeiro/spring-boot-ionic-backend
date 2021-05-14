package com.teophiloribeiro.curso.services;

import javax.mail.internet.MimeMessage;

import com.teophiloribeiro.curso.domain.Cliente;
import com.teophiloribeiro.curso.domain.Pedido;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);

    void sendOrderConfirmationHtmlEmail(Pedido obj);
    
    void sendHtmlEmail(MimeMessage msg);

    void sendNewPasswordEmail(Cliente cliente, String newPass);
}
