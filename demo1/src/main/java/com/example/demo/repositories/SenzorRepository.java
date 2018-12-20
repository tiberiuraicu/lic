package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Senzor;
import com.example.demo.entites.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SenzorRepository extends JpaRepository<Senzor, Integer> {

	Senzor getSenzorByNume(String nume);

}