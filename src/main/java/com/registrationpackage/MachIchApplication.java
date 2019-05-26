package com.registrationpackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories ("com.registrationpackage.repository")
@SpringBootApplication
public class MachIchApplication {

	public static void main(String[] args) {

		SpringApplication.run(MachIchApplication.class, args);
	}

}

