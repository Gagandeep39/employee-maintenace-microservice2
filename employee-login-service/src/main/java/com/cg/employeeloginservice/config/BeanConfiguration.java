package com.cg.employeeloginservice.config;

import java.sql.SQLException;
import java.util.Collections;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class BeanConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseaServer() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9050");
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
			"Validations API", 
			"API used to carry out login operation",
			"1.0G", 
			"My Terms of Services",
			new Contact("Pranav Karmarkar", "https://github.com/pranavk22", "pranav.karmarkar4@gmail.com"),
			"API license", 
			"www.pranav.com", 
			Collections.emptyList());
	}

}