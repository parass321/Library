package com.self.BookStore;

import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class BookConfig {
	
	
    @Bean
	public Docket docket() {
    	return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build();
		
	}

    
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder().title("This Is book API").description("Book service").build();
    }
	
	
}
