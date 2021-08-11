package com.chandra.childMicroserviceFour.Service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandra.childMicroserviceFour.DAO.ChildMicroserviceFourDAO;
import com.chandra.childMicroserviceFour.Entity.userSubjectEntity;
import com.chandra.childMicroserviceFour.Model.userSubjectModel;
@Service(value = "ChildMicroserviceOneService")
@Transactional
public class ChildMicroserviceFourServiceImpl implements ChildMicroserviceFourService 
{
	@Autowired
	ChildMicroserviceFourDAO childMicroserviceOneDAO;
	
	public List<userSubjectModel> getAllUserSubject()
	{
		System.err.println("in service");
		return (childMicroserviceOneDAO.getAllUserSubject());
		
	}
	public userSubjectModel getOneUserSubject(Integer id)
	{
		return (childMicroserviceOneDAO.getOneUserSubject(id));	
	}
	public userSubjectEntity insertUserSubject(userSubjectModel sM)
	{
		System.err.println(sM);
		return (childMicroserviceOneDAO.insertUserSubject(sM));
	}
}
