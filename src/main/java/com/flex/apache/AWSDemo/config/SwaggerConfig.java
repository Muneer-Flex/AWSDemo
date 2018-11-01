/**
 * 
 */
package com.flex.apache.AWSDemo.config;

import static com.flex.apache.AWSDemo.util.AppConstants.ABOUT;
import static com.flex.apache.AWSDemo.util.AppConstants.APP_NAME;
import static com.flex.apache.AWSDemo.util.AppConstants.APP_TITLE;
import static com.flex.apache.AWSDemo.util.AppConstants.CONTACT_EMAIL;
import static com.flex.apache.AWSDemo.util.AppConstants.SWAGGER_URL;
import static com.flex.apache.AWSDemo.util.AppConstants.VERSION;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class contains Swagger configuration.
 * 
 * @author gssmunej
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport{

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
        		.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
        		//.apis(RequestHandlerSelectors.basePackage("org.springframework.boot"))
        		.paths(regex("/.*"))
                .build()
                .apiInfo(metaData());
    }
	
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(SWAGGER_URL)
                .addResourceLocations("classpath:/META-INF/resources/");
 
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
  
   private ApiInfo metaData() {
      return new ApiInfoBuilder()
              .title(APP_TITLE)
              .description("\"REST API for Account Management\"")
              .version(VERSION)
              .contact(new Contact(APP_NAME, ABOUT, CONTACT_EMAIL))
              .build();
   }
}
