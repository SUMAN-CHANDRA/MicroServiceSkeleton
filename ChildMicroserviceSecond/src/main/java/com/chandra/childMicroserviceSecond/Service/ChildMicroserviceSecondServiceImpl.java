package com.chandra.childMicroserviceSecond.Service;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.chandra.childMicroserviceSecond.Model.EmailStatus;


@Service(value = "ChildMicroserviceSecondService")
public class ChildMicroserviceSecondServiceImpl implements ChildMicroserviceSecondService 
{
	@Bean
	public JavaMailSender getJavaMailSender() 
	{
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername("suman.puku@gmail.com");
	    mailSender.setPassword("VIVEKANANDA");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    return mailSender;
	}
	
	@Autowired
	public JavaMailSender emailSender;
	
	@Autowired
	EmailHtmlSender emailHtmlSender;
	
	public void sendmail() throws AddressException, MessagingException, IOException
	{
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("shubhranshu181@gmail.com"); 
        message.setSubject("subject"); 
        message.setText("Mail from Java Code");
        emailSender.send(message);
	}
	
	public void sendHtmlEmail(String to, String subject, String body) throws AddressException, MessagingException, IOException
	{
		Context context = new Context();
		context.setVariable("title", "Lorem Ipsum");
		context.setVariable("description", "Lorem Lorem Lorem");
		EmailStatus emailStatus = emailHtmlSender.send(to, "Title of email", "email/blog-stories", context);
	}
		
	}
