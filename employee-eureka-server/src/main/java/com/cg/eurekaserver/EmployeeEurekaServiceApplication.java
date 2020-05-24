package com.cg.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableEurekaServer
public class EmployeeEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeEurekaServiceApplication.class, args);
	}

}
