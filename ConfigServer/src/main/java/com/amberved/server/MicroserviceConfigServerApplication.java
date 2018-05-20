package com.amberved.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;



//@Configuration
//@EnableAutoConfiguration
//@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
public class MicroserviceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigServerApplication.class, args);
	}
}
