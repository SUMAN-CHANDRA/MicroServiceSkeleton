package com.chandra.childMicroserviceOne.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.chandra.childMicroserviceOne.Entity.userEntity;
import com.chandra.childMicroserviceOne.Model.userModel;

@Repository(value="ChildMicroserviceOneDAO")
public class ChildMicroserviceOneDAOImpl implements ChildMicroserviceOneDAO 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<userModel> getAllUser()
	{
		System.err.println("in DAO 1");
		String queryString ="SELECT u FROM userEntity u";
		System.err.println("in DAO 2");
		Query query=entityManager.createQuery(queryString);
		System.err.println("in DAO 3");
		@SuppressWarnings("unchecked")
		List<userEntity> li_entity = query.getResultList();
		System.err.println("in DAO 4");
		List<userModel> result= new ArrayList<userModel>();
		for(int i=0;i<li_entity.size();i++)
		{
			userModel uM = new userModel();
			result.add(uM.entityToModel(li_entity.get(i)));
		}
		
		return result;
		
	}
	public userModel getOneUser(Integer id)
	{
		userEntity uE=entityManager.find(userEntity.class,id);
		userModel uM= new userModel();
		return(uM.entityToModel(uE));
	}
	
	public userEntity insertUser(userModel uM)
	{
		System.err.println(uM);
		userEntity temp=uM.modelToEntity(uM);
		entityManager.persist(temp);
		return(temp);
	}

}
