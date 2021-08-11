package com.chandra.childMicroserviceThree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages ="com.chandra.childMicroserviceThree.*")
public class ChildMicroserviceThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChildMicroserviceThreeApplication.class, args);
	}

}
