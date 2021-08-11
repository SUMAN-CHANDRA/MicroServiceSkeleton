package com.chandra.childMicroserviceFour.Model;

import com.chandra.childMicroserviceFour.Entity.userSubjectEntity;

public class userSubjectModel
{
	private Integer userSubjectId;
	private String userSubjectName;

	
	
	public Integer getUserSubjectId() {
		return userSubjectId;
	}

	public void setUserSubjectId(Integer userSubjectId) {
		this.userSubjectId = userSubjectId;
	}

	public String getUserSubjectName() {
		return userSubjectName;
	}

	public void setUserSubjectName(String userSubjectName) {
		this.userSubjectName = userSubjectName;
	}

	public userSubjectModel entityToModel(userSubjectEntity uS)
	{
		this.setUserSubjectId(uS.getUserSubjectId());
		this.setUserSubjectName(uS.getUserSubjectName());
		return this;
	}
	
	public userSubjectEntity modelToEntity(userSubjectModel sM)
	{
		userSubjectEntity sE = new userSubjectEntity();
		sE.setUserSubjectName(sM.getUserSubjectName());
		return sE;
	}
	
	
	
}
