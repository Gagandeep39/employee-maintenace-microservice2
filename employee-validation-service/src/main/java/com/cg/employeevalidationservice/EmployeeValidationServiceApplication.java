package com.cg.employeevalidationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2WebMvc
public class EmployeeValidationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeValidationServiceApplication.class, args);
	}

}
