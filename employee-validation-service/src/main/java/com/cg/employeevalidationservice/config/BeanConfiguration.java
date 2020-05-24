/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-14 08:50:11
 * @modify date 2020-05-14 08:50:11
 * @desc Stores required beans
 */
package com.cg.employeevalidationservice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class BeanConfiguration {

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
			"Validations API", 
			"It fetches information to populate the dropdown in front end",
			"1.0G", 
			"My Terms of Services",
			new Contact("Pranav Karmarkar", "https://github.com/pranavk22", "pranav.karmarkar4@gmail.com"),
			"API license", 
			"www.pranav.com", 
			Collections.emptyList());
	}
    
}