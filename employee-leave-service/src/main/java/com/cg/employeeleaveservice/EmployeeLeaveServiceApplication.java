package com.cg.employeeleaveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@EnableSwagger2WebMvc
public class EmployeeLeaveServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeLeaveServiceApplication.class, args);
    }

}
