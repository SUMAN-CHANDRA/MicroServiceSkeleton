package com.chandra.childMicroserviceSecond.Controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chandra.childMicroserviceSecond.Service.ChildMicroserviceSecondService;


@RestController
@RequestMapping(value="/ChildMicroserviceSecond")
public class ChildMicroserviceSecondController 
{
	@Autowired
	RestTemplate template;
	
	@Autowired
	ChildMicroserviceSecondService childMicroserviceSecondService;
	
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	} 
	
	@RequestMapping(value = "/secondMapping", method = RequestMethod.GET)
	public void secondMapping()
	{
		System.err.println("This is the child microservice second getting mapped");
	}
	
	@RequestMapping(value = "/secondToThirdMapping", method = RequestMethod.GET)
	public void firstToThirdMapping()
	{
		String thirdUrl= "http://localhost:6666/ChildMicroserviceThree/threeMapping";
		template.getForEntity(thirdUrl,null);
		System.err.println("This is the child microservice second calling third and getting mapped");
	}
	
	@RequestMapping(value = "/sendEmail")
	public String sendEmail() throws AddressException, MessagingException, IOException 
	{
		childMicroserviceSecondService.sendmail();
		return "Email sent successfully";   
	}
	
	@RequestMapping(value = "/sendHTMLEmail")
	public String sendHtmlEmail() throws AddressException, MessagingException, IOException 
	{
	childMicroserviceSecondService.sendHtmlEmail("suman.puku@gmail.com","This is the subject matter","This is the body");
	return "Email sent successfully";   
	}

}
