package com.email.sample.controller;

import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.email.sample.value.EmailMessage;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


@Controller
@RequestMapping("/api/v1/email")
public class EmailController {
	
	@PostMapping("/send")
	private String sendEmail(@RequestBody EmailMessage message) throws AddressException, MessagingException {
		
		String host = "send.smtp.mailtrap.io";
	      //configure Mailtrap's SMTP server details
	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");
	      
	      Session session = Session.getInstance(props, null);
	      
	      MimeMessage messages = new MimeMessage(session);
	      
	      messages.setFrom(new InternetAddress(message.getFrom()));
	      
	      InternetAddress[] addresses = getInternetAddress(message.getTo());
	      messages.setRecipients(Message.RecipientType.TO, addresses);
	      
	      messages.setSubject(message.getSubject());
	      
	      messages.setText(message.getMessage());
	      
	      messages.setContent(message.getMessage(), "text/html");
	      
	      Transport.send(messages);
	      
		  return "Success";
		
	}
	
	private InternetAddress[] getInternetAddress(String [] to) throws AddressException {
		
		InternetAddress[] addrss =  new InternetAddress[to.length];
		
		for (int i=0;i<to.length;i++) {
			
			addrss[i]= new InternetAddress(to[i]);
			
		}
		
		return addrss;
		
	}

}
