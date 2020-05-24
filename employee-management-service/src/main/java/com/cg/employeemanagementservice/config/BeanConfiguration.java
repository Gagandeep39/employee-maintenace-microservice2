package com.cg.employeemanagementservice.config;

import java.util.Collections;

import com.cg.employeemanagementservice.entity.User;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Gagandeep
 * @date 07-05-2020
 * @time 02:15
 */

/**
 * Stores all necessary Beans
 */
@Configuration
public class BeanConfiguration {

	/**
	 * Intermicroservice Communication
	 */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

	/**
	 * Fetch a dummy user to Indicate that login server is down
	 */
    @Bean
    public User getUser(){
        User user = new User();
        user.setEmpId(0);
        user.setUsername("Error Communicating with Login Service");
        return user;
    }

    /**
	 * Docket Manages All Documentation
	 * select() To modify the default settings of Docket To ovverride settings
	 * build() To generate a docket object with above modified settings
	 * apis() to specify the endpoints to be shown in Swagger
	 * apiInfo() to provide custom API Info
	 */
	@Bean
	public Docket swaggerCongiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
			// .select()
			// .paths(PathSelectors.ant("/api/*"))
			// .apis(RequestHandlerSelectors.basePackage("com.spring"))
			// .build()
			.apiInfo(apidetails());
	}

	/**
	 * API Info 
	 * Name
	 * Description
	 * Version
	 * Terms of Services
	 * Contacts Info
	 * License Info
	 * Company URL
	 * Addition Vender Info (Collections<VendorInfo> asd)
	 */
	private ApiInfo apidetails() {
		return new ApiInfo(
			"Management API", 
			"API to manage Employee Related Oeprations",
			"1.0G", 
			"My Terms of Services",
			new Contact("Gagandeep Singh", "github.com/gagandeep39", "singh.gagandeep3911@gmail.com"),
			"API license", 
			"www.gagandeep.com", 
			Collections.emptyList());
	}

}
