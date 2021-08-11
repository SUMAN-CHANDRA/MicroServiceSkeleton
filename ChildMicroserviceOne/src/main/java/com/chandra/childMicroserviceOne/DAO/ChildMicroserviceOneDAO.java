package com.chandra.childMicroserviceOne.DAO;

import java.util.List;

import com.chandra.childMicroserviceOne.Entity.userEntity;
import com.chandra.childMicroserviceOne.Model.userModel;

public interface ChildMicroserviceOneDAO
{

	public List<userModel> getAllUser();
	public userModel getOneUser(Integer id);
	public userEntity insertUser(userModel uM);
	
	

	
}
