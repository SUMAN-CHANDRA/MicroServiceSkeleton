package com.chandra.childMicroserviceOne.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="userinfo")
public class userEntity
{
	@Id
	@Column(name="user_id")
//    @SequenceGenerator(name="pkgen",sequenceName="customer_sequence",allocationSize=1)
//	@GeneratedValue(generator="pkgen",strategy=GenerationType.SEQUENCE)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	@Column(name="user_first_name")
	private String firstName;
	
	@Column(name="user_last_name")
	private String lastName;
	
	@Column(name="user_subject")
	private String subject;
	
	@Column(name="user_phone_no")
	private Integer phoneNo;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_teacher")
	private Integer teacher;
	
	@Column(name="user_password")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) 
	{
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTeacher() {
		return teacher;
	}

	public void setTeacher(Integer teacher) {
		this.teacher = teacher;
	}
	
	
}
