package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Dispozitiv;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DispozitivRepository extends JpaRepository<Dispozitiv, Integer> {

	Dispozitiv findByName(String string);
	


}