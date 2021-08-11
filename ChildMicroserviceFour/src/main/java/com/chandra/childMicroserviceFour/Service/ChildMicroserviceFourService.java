package com.chandra.childMicroserviceFour.Service;

import java.util.List;

import com.chandra.childMicroserviceFour.Entity.userSubjectEntity;
import com.chandra.childMicroserviceFour.Model.userSubjectModel;

public interface ChildMicroserviceFourService
{
	public List<userSubjectModel> getAllUserSubject();
	public userSubjectModel getOneUserSubject(Integer id);
	public userSubjectEntity insertUserSubject(userSubjectModel sM);

	
}
