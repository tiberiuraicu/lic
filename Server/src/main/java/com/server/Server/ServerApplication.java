package com.server.Server;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.server.Server.cep.generator.AdaugaLaConsumEventGenerator;
import com.server.Server.cep.generator.PrizaNefolositaEventGenerator;
import com.server.Server.cep.processing.FnctiiAjutor;
import com.server.Server.database.repositories.AlimentatorRepository;
import com.server.Server.database.repositories.ConsumatorRepository;
import com.server.Server.database.repositories.DispozitivRepository;
import com.server.Server.database.repositories.NotificareRepository;
import com.server.Server.database.repositories.UserRepository;
import com.server.Server.entites.Alimentator;
import com.server.Server.entites.Circuit;
import com.server.Server.entites.Consumator;
import com.server.Server.entites.Dispozitiv;
import com.server.Server.entites.Intrerupator;
import com.server.Server.entites.Notificare;
import com.server.Server.entites.Priza;
import com.server.Server.entites.Senzor;
import com.server.Server.entites.User;

@SpringBootApplication

public class ServerApplication implements CommandLineRunner {

	@Autowired
	AdaugaLaConsumEventGenerator adaugaLaConsumEventGenerator;
	@Autowired
	PrizaNefolositaEventGenerator prizaNefolositaEventGenerator;
	
	@Autowired
	private AlimentatorRepository alimentatorRepository;
	@Autowired
	private DispozitivRepository dispozitivRepository;
	@Autowired
	private ConsumatorRepository consumatorRepository;
	@Autowired
	NotificareRepository notificareRepository;
	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	
	@Override
	public void run(String... strings) throws Exception {	
		System.out.println("ceva");
		FnctiiAjutor fnctiiAjutor = new FnctiiAjutor();
		alimentatorRepository.save(fnctiiAjutor.getAlimentator());

	
		
		 
		
		
		adaugaLaConsumEventGenerator.startSendingTemperatureReadings();	
		//prizaNefolositaEventGenerator.startSendingTemperatureReadings();
		
//		User user = new User();
//		user.setEmail("user@user.com");
//		user.setLocalitatea("Brasov");
//		user.setNumarDeTelefon(0000000000);
//		user.setNume("User1N");
//		user.setPrenume("User1P");
//		//user.setRol(new Rol(true, false));
//		user.setStrada("nr 17");
//		user.setTara("Romania");
//
//		Dispozitiv dispozitiv = new Dispozitiv();
//		dispozitiv.setLocalitatea("Brasov");
//		dispozitiv.setTrimiteNotificari(true);
//		dispozitiv.setStrada("nr 17");
//		dispozitiv.setTara("Romania");
//		dispozitiv.setName("raspberry");
//
//		Consumator bec = new Priza();
//		//bec.setCircuit("1");
//		//bec.setCircuit(new Circuit(null, 0, null));
//		bec.setDataOra(new Date());
//		bec.setPutereConsumata(500);
//		//bec.setStare(1);
//		bec.setTip("bec");
//		//bec.setNume("bec");
//		
//
//		Consumator frigider = new Intrerupator();
//		//frigider.setCircuit("1");
//		frigider.setDataOra(new Date());
//		frigider.setPutereConsumata(500);
//		//frigider.setStare(true);
//		frigider.setTip("frigider");
//
//		Consumator aspirator = new Consumator();
//		aspirator.setCircuit(new Circuit(null, 0, null));
//		aspirator.setDataOra(new Date());
//		aspirator.setPutereConsumata(500);
//		aspirator.setStare(1);
//		aspirator.setTip("aspirator");
//
//		com.server.Server.entites.Senzor lumina = new Senzor();
//		lumina.setCircuit("1");
//		lumina.setLocatia("Bucatarie");
//		lumina.setNume("lumina");
//		lumina.setDataOra(new Date());
//		//lumina.setStare("activ");
//
//		Senzor miscare = new Senzor();
//		miscare.setCircuit("1");
//		miscare.setLocatia("Bucatarie");
//		miscare.setNume("miscare");
//		miscare.setDataOra(new Date());
//		//miscare.setStare("activ");
//
//		Notificare notificare1 = new Notificare();
//		notificare1.setCorp("corp notificare 1");
//		notificare1.setDataOra(new Date());
//		notificare1.setTitlu("notificare1");
//
//		Notificare notificare2 = new Notificare();
//		notificare2.setCorp("corp notificare 2");
//		notificare2.setDataOra(new Date());
//		notificare2.setTitlu("notificare2");
//
//		userRepository.save(user);
//		consumatorRepository.save(bec);
//		consumatorRepository.save(frigider);
//		notificareRepository.save(notificare1);
//
//		 for (User book : userRepository.findAll()) {
//		 System.out.println(book.toString());
//		
//		 }
//		 for (Notificare book : notificareRepository.findAll()) {
//			 System.out.println(book.toString());
//			
//			 
//			 }
//		 for (Consumator book : 	 consumatorRepository.findAll()) {
//			 System.out.println(book.toString());
//			
//			 
//			 }
		
	}
}

