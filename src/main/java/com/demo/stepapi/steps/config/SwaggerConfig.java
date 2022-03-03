package com.demo.stepapi.steps.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * /swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.stepapi.steps.controller"))
                .build()
                .apiInfo( myApiInfo() );
    }

    private ApiInfo myApiInfo(){
        return new ApiInfo( 
            "title: The title of my API", 
            "description: some useful description for the API", 
            "version: the versio is 1.0", 
            "termsOfServiceUrl: YOu can see the terms in the following URL..", 
            new Contact("Polo", "www.sample.com", "user@email.com"), 
            "license: Licence MIT", 
            "licenseUrl: Check in the url", 
            Collections.emptyList() );
    }

}
