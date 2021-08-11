package com.chandra.childMicroserviceOne.Service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandra.childMicroserviceOne.DAO.ChildMicroserviceOneDAO;
import com.chandra.childMicroserviceOne.Entity.userEntity;
import com.chandra.childMicroserviceOne.Model.userModel;
@Service(value = "ChildMicroserviceOneService")
@Transactional
public class ChildMicroserviceOneServiceImpl implements ChildMicroserviceOneService 
{
	@Autowired
	ChildMicroserviceOneDAO childMicroserviceOneDAO;
	
	public List<userModel> getAllUser()
	{
		System.err.println("in service");
		return (childMicroserviceOneDAO.getAllUser());
		
	}
	public userModel getOneUser(Integer id)
	{
		return (childMicroserviceOneDAO.getOneUser(id));	
	}
	public userEntity insertUser(userModel uM)
	{
		System.err.println(uM);
		return (childMicroserviceOneDAO.insertUser(uM));
	}
}
