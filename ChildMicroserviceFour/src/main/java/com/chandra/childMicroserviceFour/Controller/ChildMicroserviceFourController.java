package com.chandra.childMicroserviceFour.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chandra.childMicroserviceFour.Configuration.RibbonConfiguration;
import com.chandra.childMicroserviceFour.Entity.userSubjectEntity;
import com.chandra.childMicroserviceFour.Model.userSubjectModel;
import com.chandra.childMicroserviceFour.Service.ChildMicroserviceFourService;
import com.sun.jersey.server.wadl.WadlGenerator.Environment;



@RestController
@RequestMapping(value="/ChildMicroserviceFour")
public class ChildMicroserviceFourController 
{
	
//	@Autowired
//	RestTemplate template;
	
	@Autowired
	ChildMicroserviceFourService childMicroserviceFourService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/getUserSubject", method = RequestMethod.GET)
	public List<userSubjectModel> getAllUser()
	{
		System.err.println("get all");
		System.out.println(childMicroserviceFourService.getAllUserSubject());
		return(childMicroserviceFourService.getAllUserSubject());
	}
	
	@RequestMapping(value = "/getUserSubject/{userId}", method = RequestMethod.GET)
	public userSubjectModel getOneUser(@PathVariable Integer userId)
	{
		System.err.println("get One");
		System.out.println(childMicroserviceFourService.getOneUserSubject(userId));
		return(childMicroserviceFourService.getOneUserSubject(userId));
	}
	
	
	@RequestMapping(value = "/newUserSubject", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public userSubjectEntity login(@RequestBody userSubjectModel sM) {
		logger.info("Login request for new User "+sM.getUserSubjectName());
		System.err.println(sM);
		return (childMicroserviceFourService.insertUserSubject(sM));
	}
	

//	@RequestMapping(value = "/firstMapping", method = RequestMethod.GET)
//	public void firstMapping()
//	{
//		System.err.println("This is the child microservice one getting mapped");
//	}
//	
//	@RequestMapping(value = "/firstToSecondMapping", method = RequestMethod.GET)
//	public void firstToSecondMapping()
//	{
//		String secondUrl= "http://localhost:6666/ChildMicroserviceSecond/secondMapping";
//		template.getForEntity(secondUrl,null);
//		System.err.println("This is the child microservice one calling second and getting mapped");
//	}
//	
//	@RequestMapping(value = "/firstToThirdMapping", method = RequestMethod.GET)
//	public void firstToThirdMapping()
//	{
//		String thirdUrl= "http://localhost:6666/ChildMicroserviceThree/threeMapping";
//		template.getForEntity(thirdUrl,null);
//		System.err.println("This is the child microservice one calling third and getting mapped");
//	}

}
