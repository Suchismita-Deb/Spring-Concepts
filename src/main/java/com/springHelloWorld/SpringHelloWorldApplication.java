package com.springHelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = {"com.springHelloWorld.*",
//		"com.springHelloWorld.dto.*"
//		,"com.springHelloWorld.controller.*",
//		"com.springHelloWorld.repository.*"
//		,"com.springHelloWorld.service.*",
//		"com.springHelloWorld.model.*"
//})
//TODO: EntityScan and ComponentScan. When and why are they needed?

public class SpringHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHelloWorldApplication.class, args);
	}

}
