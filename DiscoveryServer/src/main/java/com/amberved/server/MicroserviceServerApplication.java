package com.amberved.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceServerApplication.class, args);
	}
}
