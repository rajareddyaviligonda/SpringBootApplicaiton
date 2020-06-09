package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import de.codecentric.boot.admin.config.EnableAdminServer;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//We need to extend the class SpringBootServletInitializer to support WAR file deployment

//Application Runner is an interface used to execute the code after the Spring Boot application started. 

@SpringBootApplication
@EnableSwagger2
@EnableAdminServer
public class DemoApplication extends SpringBootServletInitializer implements ApplicationRunner, CommandLineRunner  
{

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);



	public static void main(String[] args) {

		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");

		SpringApplication.run(DemoApplication.class, args);
	}

	
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.example.demo")).build();
	   }
	
	
	/*
	 * Cross-Origin Resource Sharing (CORS) is a security concept that allows
	 * restricting the resources implemented in web browsers. It prevents the
	 * JavaScript code producing or consuming the requests against different origin.
	 */
	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurerAdapter() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/products").allowedOrigins("http://localhost:9090");
	         }
	      };
	   }
	
	
	/*
	 * Rest Template is used to create applications that consume RESTful Web
	 * Services. You can use the exchange() method to consume the web services for
	 * all HTTP methods. The code given below shows how to create Bean for Rest
	 * Template to auto wiring the Rest Template object.
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


	
	  @Override protected SpringApplicationBuilder
	  configure(SpringApplicationBuilder application) { return
	  application.sources(DemoApplication.class); }
	  
	  // Application Runner is an interface used to execute the code after the
//	  Spring Boot application started.
	  
	  @Override public void run(ApplicationArguments arg0) throws Exception {
	  System.out.println("Hello World from Application Runner"); }
	  
	  // Command Line Runner is an interface. It is used to execute the code after
//	  the Spring Boot application started
	  
	  @Override public void run(String... args) throws Exception {
	  System.out.println("Hello world from Command Line Runner"); }
	 
}
