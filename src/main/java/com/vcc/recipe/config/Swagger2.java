package com.vcc.recipe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableSwaggerBootstrapUI
@Configuration
public class Swagger2 {
	
	  @Bean
	  public Docket baseApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("模板接口").apiInfo(apiBaseInfo()).select().apis(RequestHandlerSelectors.basePackage("com.vcc.recipe"))
			.paths(PathSelectors.regex(".*/base/.*")).build();
	  }

	  private ApiInfo apiBaseInfo() {
		return new ApiInfoBuilder().title("模板接口文档").description("模板接口文档").termsOfServiceUrl("").version("1.0").build();
	  }

	  @Bean
	  public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("API管理接口").apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.vcc.recipe"))
			.paths(PathSelectors.regex(".*/api/.*")).build();
	  }

	  private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API文档").description("API文档").termsOfServiceUrl("").version("1.0").build();
	  }

	  @Bean
	  public Docket backApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("后台管理接口").apiInfo(apiBackInfo()).select().apis(RequestHandlerSelectors.basePackage("com.vcc.recipe"))
			.paths(PathSelectors.regex(".*/back/.*")).build();
	  }

	  private ApiInfo apiBackInfo() {
		return new ApiInfoBuilder().title("后台管理接口").description("后台管理接口实现的文档").termsOfServiceUrl("").version("1.0").build();
	  }

}

