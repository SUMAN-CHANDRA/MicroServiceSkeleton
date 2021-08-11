package com.chandra.childMicroserviceThree.Service;

import java.util.List;

import com.chandra.childMicroserviceThree.Entity.messageEntity;
import com.chandra.childMicroserviceThree.Model.messageModel;

public interface ChildMicroserviceThreeService
{
	public List<messageModel> getAllMessageGroup(Integer groupId);
	public messageEntity insertMessage(messageModel uM);
}
