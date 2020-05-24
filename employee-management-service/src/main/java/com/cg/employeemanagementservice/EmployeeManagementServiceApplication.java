package com.cg.employeemanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
@EnableEurekaClient
@EnableSwagger2WebMvc
public class EmployeeManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementServiceApplication.class, args);
    }

}
