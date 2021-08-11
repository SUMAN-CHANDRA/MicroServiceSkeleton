package com.chandra.childMicroserviceSecond.Service;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;



public interface ChildMicroserviceSecondService
{
	public void sendmail() throws AddressException, MessagingException, IOException;
	public void sendHtmlEmail(String to, String subject, String body) throws AddressException, MessagingException, IOException;
	
}
