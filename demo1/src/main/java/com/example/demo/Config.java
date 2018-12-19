package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.services.ServiciiDispozitiv;

@Configuration
public class Config {

	@Bean
	public ServiciiDispozitiv serviciiDispozitiv() {
		return new ServiciiDispozitiv();
	}
}
