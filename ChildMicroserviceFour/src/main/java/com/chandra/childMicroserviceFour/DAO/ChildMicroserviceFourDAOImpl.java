package com.chandra.childMicroserviceFour.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.chandra.childMicroserviceFour.Entity.userSubjectEntity;
import com.chandra.childMicroserviceFour.Model.userSubjectModel;

@Repository(value="ChildMicroserviceOneDAO")
public class ChildMicroserviceFourDAOImpl implements ChildMicroserviceFourDAO 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<userSubjectModel> getAllUserSubject()
	{
		System.err.println("in DAO 1");
		String queryString ="SELECT s FROM userSubjectEntity s";
		System.err.println("in DAO 2");
		Query query=entityManager.createQuery(queryString);
		System.err.println("in DAO 3");
		@SuppressWarnings("unchecked")
		List<userSubjectEntity> li_entity = query.getResultList();
		System.err.println("in DAO 4");
		List<userSubjectModel> result= new ArrayList<userSubjectModel>();
		for(int i=0;i<li_entity.size();i++)
		{
			userSubjectModel uM = new userSubjectModel();
			result.add(uM.entityToModel(li_entity.get(i)));
		}
		
		return result;
		
	}
	public userSubjectModel getOneUserSubject(Integer id)
	{
		userSubjectEntity sE=entityManager.find(userSubjectEntity.class,id);
		userSubjectModel sM= new userSubjectModel();
		return(sM.entityToModel(sE));
	}
	
	public userSubjectEntity insertUserSubject(userSubjectModel uS)
	{
		System.err.println(uS);
		userSubjectEntity temp=uS.modelToEntity(uS);
		entityManager.persist(temp);
		return(temp);
	}

}
