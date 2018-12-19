package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.example.demo.entites.Dispozitiv;
import com.example.demo.entites.User;
import com.example.demo.repositories.UserRepository;

@EnableJpaRepositories(basePackages="com.example.demo.repositories") 
@Component
public class ServiciiUser {
	@Autowired
	UserRepository userRepository;
	
	public void addDispozitiv(User user, Dispozitiv dispozitiv) {
	user.getDispozitive().add(dispozitiv);	
	}
}
