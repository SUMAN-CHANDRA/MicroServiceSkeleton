package com.chandra.childMicroserviceThree.Model;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;

import com.chandra.childMicroserviceThree.Entity.messageEntity;

public class messageModel
{
	private Integer messageId;
	private Integer groupId;
	private Integer userId;
	private String message;
	private LocalDateTime messageDateTime;
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
	public LocalDateTime getMessageDateTime() {
		return messageDateTime;
	}
	public void setMessageDateTime(LocalDateTime messageDateTime) {
		this.messageDateTime = messageDateTime;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
		
	public messageModel entityToModel(messageEntity mE)
	{
		this.setMessageId(mE.getMessageId());
		this.setGroupId(mE.getGroupId());
		this.setUserId(mE.getUserId());
		this.setMessage(mE.getMessage());
		this.setMessageDateTime(mE.getMessageTimeStamp());
		this.setAttachment(mE.getAttachment());
		
		return this;
		
	}
	
	public messageEntity modelToEntity(messageModel uM)
	{
		messageEntity mE = new messageEntity();
		//mE.setMessageId(uM.getMessageId());
		mE.setGroupId(uM.getGroupId());
		mE.setUserId(uM.getUserId());
		//mE.setMessage(new String(uM.getMessage(), StandardCharsets.UTF_8));
		mE.setMessage(uM.getMessage());
		mE.setMessageTimeStamp(uM.getMessageDateTime());
		mE.setAttachment(uM.getAttachment());
	
		return mE;
	}
	
	
	
}
