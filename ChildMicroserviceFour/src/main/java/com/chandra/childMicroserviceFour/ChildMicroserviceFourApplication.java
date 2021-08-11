package com.chandra.childMicroserviceFour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages ="com.chandra.childMicroserviceFour.*")
public class ChildMicroserviceFourApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChildMicroserviceFourApplication.class, args);
	}

}
