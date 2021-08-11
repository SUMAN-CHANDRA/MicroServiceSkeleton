package com.chandra.childMicroserviceSecond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages ="com.chandra.childMicroserviceSecond.*")
public class ChildMicroserviceSecondApplication {

	public static void main(String[] args) 
	{
		System.out.println("1");
		SpringApplication.run(ChildMicroserviceSecondApplication.class, args);
		System.out.println("2");
	}

}
