package com.chandra.childMicroserviceFour.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_subject")
public class userSubjectEntity
{
	@Id
	@Column(name="user_subject_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userSubjectId;
	
	@Column(name="user_subject_name")
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
	
	
}
