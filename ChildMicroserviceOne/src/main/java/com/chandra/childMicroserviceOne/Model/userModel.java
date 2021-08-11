package com.chandra.childMicroserviceOne.Model;

import com.chandra.childMicroserviceOne.Entity.userEntity;

public class userModel
{
	private Integer userId;
	private String firstName;
	private String lastName;
	private String subject;
	private Integer phoneNo;
	private String emailId;
	private Integer teacher;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getTeacher() {
		return teacher;
	}
	public void setTeacher(Integer teacher) {
		this.teacher = teacher;
	}
	
	public userModel entityToModel(userEntity uE)
	{
		this.setFirstName(uE.getLastName());
		this.setLastName(uE.getFirstName());
		this.setSubject(uE.getSubject());
		this.setPhoneNo(uE.getPhoneNo());
		this.setTeacher(uE.getTeacher());
		this.setUserId(uE.getUserId());
		this.setEmailId(uE.getEmail());
		this.setPassword(uE.getPassword());
		
		return this;
		
	}
	
	public userEntity modelToEntity(userModel uM)
	{
		userEntity uE = new userEntity();
		
		uE.setFirstName(uM.getLastName());
		uE.setLastName(uM.getFirstName());
		uE.setSubject(uM.getSubject());
		uE.setPhoneNo(uM.getPhoneNo());
		uE.setTeacher(uM.getTeacher());
		uE.setEmail(uM.getEmailId());
		uE.setPassword(uM.getPassword());
		return uE;
	}
	
	
	
}
