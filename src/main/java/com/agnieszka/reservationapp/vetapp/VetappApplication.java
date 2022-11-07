package com.agnieszka.reservationapp.vetapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class VetappApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetappApplication.class, args);
	}
	@Bean
	Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}


