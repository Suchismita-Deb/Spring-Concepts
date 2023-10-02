package com.springHelloWorld;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.springHelloWorld.model")
@EnableJpaRepositories("com.springHelloWorld.dao") // Package containing repositories
@ComponentScan(basePackages = "com.springHelloWorld")
@OpenAPIDefinition(info = @Info(title = "Student Demo API", version = "0.1", description = "Spring Boot Learning " +
		"Information"))
public class SpringHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHelloWorldApplication.class, args);
	}

}
