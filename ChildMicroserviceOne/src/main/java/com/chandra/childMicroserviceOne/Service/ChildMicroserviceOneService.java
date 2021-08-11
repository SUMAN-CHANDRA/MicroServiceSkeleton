package com.chandra.childMicroserviceOne.Service;

import java.util.List;

import com.chandra.childMicroserviceOne.Entity.userEntity;
import com.chandra.childMicroserviceOne.Model.userModel;

public interface ChildMicroserviceOneService
{
	public List<userModel> getAllUser();
	public userModel getOneUser(Integer id);
	public userEntity insertUser(userModel uM);

	
}
