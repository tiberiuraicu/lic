package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.example.demo.entites.Consumator;
import com.example.demo.entites.Dispozitiv;
import com.example.demo.entites.Notificare;
import com.example.demo.entites.Senzor;
import com.example.demo.repositories.DispozitivRepository;



public class ServiciiDispozitiv {
	@Autowired
	DispozitivRepository dispozitivRepository;
	
	public void addSenzor(Senzor senzor, Dispozitiv dispozitiv) {
		dispozitiv.getSenzori().add(senzor);
	}
	public void addNotificare(Notificare notificare, Dispozitiv dispozitiv) {
		dispozitiv.getNotificari().add(notificare);
	}
	public void addConsumator(Consumator consumator, Dispozitiv dispozitiv) {
		dispozitiv.getConsumatori().add(consumator);
	}
}
