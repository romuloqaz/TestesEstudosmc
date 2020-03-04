package com.ifpb.edu.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.ifpb.edu.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
