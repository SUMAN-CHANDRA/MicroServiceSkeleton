package com.chandra.childMicroserviceThree.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_message")
public class messageEntity
{
	@Id
	@Column(name="message_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer messageId;
	
	@Column(name="group_id")
	private Integer groupId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="message")
	private String message;
	
	@Column(name="message_timestamp")
	private LocalDateTime messageTimeStamp ;
	
	@Column(name="message_attachment")
	private String attachment;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getMessageTimeStamp() {
		return messageTimeStamp;
	}

	public void setMessageTimeStamp(LocalDateTime messageTimeStamp) {
		this.messageTimeStamp = messageTimeStamp;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
	
	
}
