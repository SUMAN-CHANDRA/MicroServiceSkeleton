package com.chandra.childMicroserviceThree.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chandra.childMicroserviceThree.Entity.messageEntity;
import com.chandra.childMicroserviceThree.Model.messageModel;
import com.chandra.childMicroserviceThree.Service.ChildMicroserviceThreeService;

@RestController
@RequestMapping(value="/ChildMicroserviceThree")
public class ChildMicroserviceThreeController 
{
	@Autowired
	ChildMicroserviceThreeService childMicroserviceThreeService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/threeMapping", method = RequestMethod.GET)
	public void secondMapping()
	{
		System.err.println("This is the child microservice third getting mapped");
	}
	
	@RequestMapping(value = "/addMessage", method = RequestMethod.POST)
	public messageEntity insertMessage(@RequestBody messageModel uM)
	{
		logger.info("Login request for new Message");
		System.err.println(uM);
		return (childMicroserviceThreeService.insertMessage(uM));
	}
	@RequestMapping(value = "/getMessage/{groupId}", method = RequestMethod.GET)
	public List<messageModel> getOneUser(@PathVariable Integer groupId)
	{
		System.err.println("get One");
		//System.out.println(childMicroserviceThreeService.getAllMessageGroup(groupId));
		return(childMicroserviceThreeService.getAllMessageGroup(groupId));
	}
	
}
