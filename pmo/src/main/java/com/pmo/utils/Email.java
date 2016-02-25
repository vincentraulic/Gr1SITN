package com.pmo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	private String email;
	private String password;
	private String host;
	private String port;

	public Email(){
		email = "projectmanagementonlinepmo@gmail.com";
		password = "cscscscs";
		host = "smtp.gmail.com";
		port = "587";
	}

	public void send(List<String> recipients, String subject, String text){
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			for(String to : recipients){
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));
			}
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
