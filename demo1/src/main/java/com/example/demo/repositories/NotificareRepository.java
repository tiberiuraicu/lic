package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Notificare;
import com.example.demo.entites.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NotificareRepository extends JpaRepository<Notificare, Integer> {
	


}