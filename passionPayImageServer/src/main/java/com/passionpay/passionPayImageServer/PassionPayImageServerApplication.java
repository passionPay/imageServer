package com.passionpay.passionPayImageServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PassionPayImageServerApplication {

	public static final String APPLICATION_LOCATIONS = "spring.config.location="
			+ "classpath:application.yml,"
			+ "classpath:aws.yml";

	public static void main(String[] args) {
//		SpringApplication.run(PassionPayImageServerApplication.class, args);
		new SpringApplicationBuilder(PassionPayImageServerApplication.class)
				.properties(APPLICATION_LOCATIONS)
				.run(args);
	}

}
