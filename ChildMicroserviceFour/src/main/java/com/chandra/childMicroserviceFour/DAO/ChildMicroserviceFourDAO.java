package com.chandra.childMicroserviceFour.DAO;

import java.util.List;

import com.chandra.childMicroserviceFour.Entity.userSubjectEntity;
import com.chandra.childMicroserviceFour.Model.userSubjectModel;

public interface ChildMicroserviceFourDAO
{

	public List<userSubjectModel> getAllUserSubject();
	public userSubjectModel getOneUserSubject(Integer id);
	public userSubjectEntity insertUserSubject(userSubjectModel sM);
	
	

	
}
