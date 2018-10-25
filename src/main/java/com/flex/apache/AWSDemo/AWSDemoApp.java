package com.flex.apache.AWSDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * This class is the main class for AWSDemoApp
 *
 */
@SpringBootApplication
public class AWSDemoApp extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AWSDemoApp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AWSDemoApp.class, args);
	}
}
