package com.chandra.childMicroserviceThree.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.chandra.childMicroserviceThree.Entity.messageEntity;
import com.chandra.childMicroserviceThree.Model.messageModel;

@Repository(value="ChildMicroserviceThreeDAO")
@Transactional
public class ChildMicroserviceThreeDAOImpl implements ChildMicroserviceThreeDAO 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<messageEntity> getAllMessageGroup(Integer groupId)
	{
		String queryString ="SELECT m FROM messageEntity m WHERE m.groupId = ?1";
		Query query=entityManager.createQuery(queryString);
		query.setParameter(1,groupId);
		@SuppressWarnings("unchecked")
		List<messageEntity> li_entity = query.getResultList();	
		return li_entity;
	}
	public messageEntity insertMessage(messageModel uM)
	{
		messageEntity mE=uM.modelToEntity(uM);
		entityManager.persist(mE);
		return mE;
	}

}
