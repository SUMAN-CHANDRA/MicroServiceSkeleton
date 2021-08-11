package com.chandra.childMicroserviceThree.Service;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Signature;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.Cipher;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandra.childMicroserviceThree.DAO.ChildMicroserviceThreeDAO;
import com.chandra.childMicroserviceThree.Entity.messageEntity;
import com.chandra.childMicroserviceThree.Model.messageModel;
//@Service(value = "ChildMicroserviceThreeService")
@Transactional
public class ChildMicroserviceThreeServiceImpl implements ChildMicroserviceThreeService 
{
	@Autowired
	ChildMicroserviceThreeDAO childMicroserviceThreeDAO;
	
	public List<messageModel> getAllMessageGroup(Integer groupId)
	{
		List<messageEntity> response=childMicroserviceThreeDAO.getAllMessageGroup(groupId);
		List<messageModel> ret=new ArrayList<messageModel>();
		System.err.println(response);
		try {
			
			   //Creating a Signature object
		      Signature sign = Signature.getInstance("SHA256withRSA");
		      
		      //Creating KeyPair generator object
		      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		      
		      //Initializing the key pair generator
		      keyPairGen.initialize(2048);
		      
		      //Generate the pair of keys
		      KeyPair pair = keyPairGen.generateKeyPair();   
		      
		      //Getting the public key from the key pair
		      PublicKey publicKey = pair.getPublic();  

		      //Creating a Cipher object
		      Cipher cipher = Cipher.getInstance("RSA");
		      
		      //Initializing the same cipher for decryption
		      cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
			
			for(int i=0;i<response.size();i++)
			{
				
				
				
				messageEntity uM = response.get(i);
				
				  
			      //encrypting the data
			     // byte[] cipherText = cipher.doFinal();	 
			      byte[] cipherText = uM.getMessage().getBytes();
			      //byte[] cipherText =DatatypeConverter.parseHexBinary(uM.getMessage());
			      System.err.println("length 1 "+cipherText.length);
			      System.out.println( new String(cipherText, "UTF8"));
 
			      //Decrypting the text
			      byte[] decipheredText = cipher.doFinal(cipherText);
			      System.err.println("length 2 "+ decipheredText.length);
			      System.err.println(new String(decipheredText));
			      uM.setMessage(new String(decipheredText));
			      System.err.println("1");
			     messageModel msModel = new messageModel();
			      ret.add(msModel.entityToModel(uM));
			}
			
		}catch(Exception e)
		{
			System.out.println("Error : "+e.getMessage());
		}
		
		
		return ret;
		
	}
	public messageEntity insertMessage(messageModel uM)
	{
		byte[] byteMessage = null;
		try 
		{
		//Creating a Signature object
	      Signature sign = Signature.getInstance("SHA256withRSA");
	      
	      //Creating KeyPair generator object
	      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
	      
	      //Initializing the key pair generator
	      keyPairGen.initialize(2048);
	      
	      //Generating the pair of keys
	      KeyPair pair = keyPairGen.generateKeyPair();      
		
	      //Creating a Cipher object
	      Cipher cipher = Cipher.getInstance("RSA");
	        
	      //Initializing a Cipher object
	      cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
		  
	      //Adding data to the cipher
	      byte[] input = uM.getMessage().getBytes();	  
	      cipher.update(input);
	      
	      System.err.println("length 1 "+input.length);
		  
	      //encrypting the data
	      byte[] cipherText = cipher.doFinal();
	      
	      System.err.println("length 2 "+cipherText.length);
	      
	      uM.setMessage(new String(cipherText, "UTF8"));
	      //uM.setMessage(cipherText);
	      
	      System.err.println("length 3 "+new String(cipherText, "UTF8").length());
	      
	      System.out.println(new String(cipherText, "UTF8"));
	      
	      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	      LocalDateTime now = LocalDateTime.now();
	      System.out.println(dtf.format(now));  
	      uM.setMessageDateTime(now);
	      
	      
	      byteMessage=cipherText;
	
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e.getMessage());
		}
		
	    return childMicroserviceThreeDAO.insertMessage(uM);
		
	}
}
