package com.amberved.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClient {

	@Value("${client.role}")
	private String role;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClient.class, args);
	}

	@RequestMapping("/role")
	public String role() {
		return String.format("%s...\n", role);
	}
	
    @Autowired
    Environment env;
    
//    http://localhost:8080/env/client.role
    @Bean
    public CommandLineRunner printProperties(@Value("${client.role}") final String role)  {
        return args -> System.out.println("client.role is: " + role);
    }
    
    @RestController
    @RefreshScope
    class ExampleController {

        @Value("${client.role_extra}")
        private String value;

        @RequestMapping
        public String sayValue() {
            return value;
        }
    }
}
