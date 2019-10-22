package com.test.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Sets;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

  
  
  @Bean
  public Docket swaggerPersonApi10() {
      return new Docket(DocumentationType.SWAGGER_2)
          .groupName("demorestapi-1.0")
          .select()
              .apis(RequestHandlerSelectors.basePackage("com.test.demo.controller"))
              .paths(PathSelectors.ant("/api/v1/**"))
          .build()
          //.pathMapping("/api/v1")
          .produces(Sets.newHashSet(APPLICATION_JSON_VALUE))
          .consumes(Sets.newHashSet(APPLICATION_JSON_VALUE));
         // .apiInfo(V1_API_INFO);
  }
   
  @Bean
  public Docket swaggerPersonApi20() {
      return new Docket(DocumentationType.SWAGGER_2)
    	  .groupName("demorestapi-2.0")
          .select()
              .apis(RequestHandlerSelectors.basePackage("com.test.demo.controller"))
              .paths(PathSelectors.ant("/api/v2/**"))
          .build()
          //.pathMapping("/api/v2")
          .produces(Sets.newHashSet(APPLICATION_JSON_VALUE))
          .consumes(Sets.newHashSet(APPLICATION_JSON_VALUE));
          //.apiInfo(V2_API_INFO);
  }
}
