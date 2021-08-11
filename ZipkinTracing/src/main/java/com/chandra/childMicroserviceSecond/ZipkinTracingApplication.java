package com.chandra.childMicroserviceSecond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import zipkin.server.EnableZipkinServer;	



@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class ZipkinTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinTracingApplication.class, args);
	}

}
