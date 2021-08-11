package com.chandra.childMicroserviceThree.DAO;

import java.util.List;

import com.chandra.childMicroserviceThree.Entity.messageEntity;
import com.chandra.childMicroserviceThree.Model.messageModel;

public interface ChildMicroserviceThreeDAO
{

	public List<messageEntity> getAllMessageGroup(Integer groupId);
	public messageEntity insertMessage(messageModel uM);
	
	

	
}
