package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.entites.Consumator;
import com.example.demo.entites.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@EnableJpaRepositories(basePackages="com.example.demo.repositories") 
public interface ConsumatorRepository extends JpaRepository<Consumator, Integer> {
	


}