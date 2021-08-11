package com.chandra.childMicroserviceOne.Controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chandra.childMicroserviceOne.Configuration.RibbonConfiguration;
import com.chandra.childMicroserviceOne.Entity.userEntity;
import com.chandra.childMicroserviceOne.Model.userModel;
import com.chandra.childMicroserviceOne.Service.ChildMicroserviceOneService;
import com.sun.jersey.server.wadl.WadlGenerator.Environment;



@RestController
@RequestMapping(value="/ChildMicroserviceOne")
public class ChildMicroserviceOneController 
{
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	ChildMicroserviceOneService childMicroserviceOneService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<userModel> getAllUser()
	{
		System.err.println("get all");
		System.out.println(childMicroserviceOneService.getAllUser());
		return(childMicroserviceOneService.getAllUser());
	}
	
	@RequestMapping(value = "/getUsers/{userId}", method = RequestMethod.GET)
	public userModel getOneUser(@PathVariable Integer userId)
	{
		System.err.println("get One");
		System.out.println(childMicroserviceOneService.getAllUser());
		return(childMicroserviceOneService.getOneUser(userId));
	}
	
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public userEntity login(@RequestBody userModel uM) {
		logger.info("Login request for new User", uM.getFirstName(), uM.getEmailId());
		System.err.println(uM);
		return (childMicroserviceOneService.insertUser(uM));
	}
	

	@RequestMapping(value = "/firstMapping", method = RequestMethod.GET)
	public void firstMapping()
	{
		System.err.println("This is the child microservice one getting mapped");
	}
	
	@RequestMapping(value = "/firstToSecondMapping", method = RequestMethod.GET)
	public void firstToSecondMapping()
	{
		String secondUrl= "http://localhost:6666/ChildMicroserviceSecond/secondMapping";
		template.getForEntity(secondUrl,null);
		System.err.println("This is the child microservice one calling second and getting mapped");
	}
	
	@RequestMapping(value = "/firstToThirdMapping", method = RequestMethod.GET)
	public void firstToThirdMapping()
	{
		String thirdUrl= "http://localhost:6666/ChildMicroserviceThree/threeMapping";
		template.getForEntity(thirdUrl,null);
		System.err.println("This is the child microservice one calling third and getting mapped");
	}
	@RequestMapping(value = "/vaccinate", method = RequestMethod.GET)
	public void vaccinate()
	{
		String vaccineUrl= "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=700015&date=24-05-2021";
		template.getForEntity(vaccineUrl,null);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>("Accept-Language:en_US", headers);
		System.out.println(template.exchange(vaccineUrl, HttpMethod.GET, entity, String.class));
		System.err.println("This is the child microservice one calling vaccine and getting mapped");
	}
	

}
