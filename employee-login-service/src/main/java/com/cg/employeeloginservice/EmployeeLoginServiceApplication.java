package com.cg.employeeloginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
public class EmployeeLoginServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeLoginServiceApplication.class, args);
    }

}
