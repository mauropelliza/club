package com.clubproject.config;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.clubproject.config.security.jwt.JWTSecurityConstants;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.clubproject.config.WebMvcConfiguration;

/**
 * 
 * # Ver Swagger.json : http://localhost:8080/v2/api-docs # Ver documentacion
 * html Swagger UI : http://localhost:8080/swagger-ui.html o bien
 * http://localhost:8080/swagger <br>
 * Para autorizar con JWT ingresar el token en Authorize->Value->Bearer <token>
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfiguration {

	@Bean
	public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select().apis(getRequestHandlers())
				.paths(PathSelectors.any()).build().apiInfo(metaData());

		// Soporte para JWT
//		docket.securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.newArrayList(apiKey()));

		return docket;

	}

	private Predicate<RequestHandler> getRequestHandlers() {
		return RequestHandlerSelectors.basePackage("com.clubproject.controller");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/swagger", "swagger-ui.html");
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	/**
	 * Permite definir la metada que se mostrara en swagger-ui.html
	 */
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("CLUB REST APIs")
				.description("Documentacion de Rest APIs para el alta de terminales en ATER2")
				.version(StringUtils.EMPTY).license(StringUtils.EMPTY).licenseUrl(StringUtils.EMPTY)
				.contact(new Contact(StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY)).build();
	}

	/**
	 * Soporte para JWT
	 */
//	private ApiKey apiKey() {
//		return new ApiKey("JWT", JWTSecurityConstants.HEADER_STRING, "header");
//	}
//
//	/**
//	 * Soporte para JWT
//	 */
//	private SecurityContext securityContext() {
//		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
//	}
//
//	/**
//	 * Soporte para JWT
//	 */
//	List<SecurityReference> defaultAuth() {
//		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//		authorizationScopes[0] = authorizationScope;
//		return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
//	}
}