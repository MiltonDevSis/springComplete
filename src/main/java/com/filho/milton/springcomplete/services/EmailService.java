package com.filho.milton.springcomplete.services;

import com.filho.milton.springcomplete.domain.Pedido;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail( Pedido obj );

    void sendEmail( SimpleMailMessage msg );
    
}
