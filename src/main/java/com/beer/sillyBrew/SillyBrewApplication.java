package com.beer.sillyBrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.beer.*")
@EntityScan("com.beer.model")
@EnableJpaRepositories("com.beer.repository")
public class SillyBrewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SillyBrewApplication.class, args);
	}

}
