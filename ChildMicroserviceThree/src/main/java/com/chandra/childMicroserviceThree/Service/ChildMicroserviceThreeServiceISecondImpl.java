package com.chandra.childMicroserviceThree.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandra.childMicroserviceThree.DAO.ChildMicroserviceThreeDAO;
import com.chandra.childMicroserviceThree.Entity.messageEntity;
import com.chandra.childMicroserviceThree.Model.messageModel;

@Service(value = "ChildMicroserviceThreeService")
public class ChildMicroserviceThreeServiceISecondImpl implements ChildMicroserviceThreeService 
{
	@Autowired
	ChildMicroserviceThreeDAO childMicroserviceThreeDAO;
	
	public List<messageModel> getAllMessageGroup(Integer groupId)
	{
		List<messageEntity> response=childMicroserviceThreeDAO.getAllMessageGroup(groupId);
		List<messageModel> ret =new ArrayList<messageModel>();
		System.err.println("The size of response "+response.size());
		for(int i=0;i<response.size();i++)
		{
			System.err.println("1");
			messageEntity mE= response.get(i); 
			String encode=mE.getMessage();
			System.err.println(encode);
			String decoded="";
			int a=0,b=0;
			for(int k=0;k < encode.length();k++)
			{
				System.err.println("2");
				int temp;
				System.err.println(Character.toString((encode.charAt(k))).equals("!"));
				if(Character.toString((encode.charAt(k))).equals("!"))
				{
					b=k;
					temp=Integer.parseInt(encode.substring(a, b));
					decoded=decoded+Character.toString((char)temp);
					a=k+1;
					System.err.println("2");
				}
				else if(Character.toString((encode.charAt(k))).equals("@"))
				{
					System.err.println("inside loop    2 "+k);
					b=k;
					temp=Integer.parseInt(encode.substring(a,b));
					System.err.println(temp+"   int");
					System.err.println("Character.toString((char)temp)      "+Character.toString((char)temp));
					decoded=decoded+Character.toString((char)temp);
					a=k+1;
					
				}
				else if(Character.toString((encode.charAt(k))).equals("#"))
				{
					b=k;
					temp=Integer.parseInt(encode.substring(a,b));
					decoded=decoded+Character.toString((char)temp);
					a=k+1;
					System.err.println("2");
				}
				
				
			}
			System.err.println(decoded);
			mE.setMessage(decoded);
			
			messageModel mM= new messageModel();
			mM=mM.entityToModel(mE);
			
			ret.add(mM);
		}
		
		return ret;
	
	}
	public messageEntity insertMessage(messageModel uM)
	{
		String encode="";
		System.err.println("inside service");
//		int shift=uM.getMessageId();
		String message=uM.getMessage();
		System.err.println(message+"        ");
		
		for(int i=0;i<message.length();i++)
		{
			String temp="";
			if(Integer.toString(((int)message.charAt(i))).length()==1)
			{
				temp="!";
			}
			else if(Integer.toString(((int)message.charAt(i))).length()==2)
			{
				temp="@";
			}
			else
			{
				temp="#";
			}
			encode=encode+Integer.toString(((int)message.charAt(i)))+temp;
		}
		uM.setMessage(encode);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();
	    System.out.println(dtf.format(now));  
	    uM.setMessageDateTime(now);
		System.err.println(uM.getMessage()+"        ");
		return(childMicroserviceThreeDAO.insertMessage(uM)) ;
		
	}
}