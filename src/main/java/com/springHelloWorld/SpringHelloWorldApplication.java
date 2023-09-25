package com.springHelloWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.springHelloWorld.model")
@EnableJpaRepositories("com.springHelloWorld.repository") // Package containing your repositories
//TODO: EntityScan and ComponentScan. When and why are they needed?
@ComponentScan(basePackages = "com.springHelloWorld.model")
public class SpringHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHelloWorldApplication.class, args);
	}

}
