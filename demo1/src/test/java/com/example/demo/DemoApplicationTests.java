package com.example.demo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entites.Consumator;
import com.example.demo.entites.Dispozitiv;
import com.example.demo.entites.Notificare;
import com.example.demo.entites.Rol;
import com.example.demo.entites.Senzor;
import com.example.demo.entites.User;
import com.example.demo.repositories.ConsumatorRepository;
import com.example.demo.repositories.DispozitivRepository;
import com.example.demo.repositories.NotificareRepository;
import com.example.demo.repositories.SenzorRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ServiciiDispozitiv;
import com.example.demo.services.ServiciiUser;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
@EnableAutoConfiguration
@WebAppConfiguration
public class DemoApplicationTests {
	private ServiciiDispozitiv serviciiDispozitiv = new ServiciiDispozitiv();
	private ServiciiUser serviciiUser = new ServiciiUser();
	private static final Logger logger = LoggerFactory.getLogger(HelloJpaApplication.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DispozitivRepository dispozitivRepository;

	@Autowired
	private NotificareRepository notificareRepository;

	@Autowired
	private SenzorRepository senzorRepository;

	@Autowired
	private ConsumatorRepository consumatorRepository;

	@Test
	public void insertUser1() {
		User user1 = new User();
		user1.setEmail("user1@user1.com");
		user1.setLocalitatea("Brasov");
		user1.setNumarDeTelefon(0000000000);
		user1.setNume("User1N");
		user1.setPrenume("User1P");
		user1.setRol(new Rol(true, false));
		user1.setStrada("nr 17");
		user1.setTara("Romania");
		userRepository.save(user1);
	}

	@Test
	public void insertUser2() {
		User user2 = new User();
		user2.setEmail("user@user.com");
		user2.setLocalitatea("Brasov");
		user2.setNumarDeTelefon(0000000000);
		user2.setNume("User2N");
		user2.setPrenume("User2P");
		user2.setRol(new Rol(true, false));
		user2.setStrada("nr 17");
		user2.setTara("Romania");
		userRepository.save(user2);
	}

	@Test
	public void insertDispozitiv() {
		Dispozitiv dispozitiv = new Dispozitiv();
		dispozitiv.setLocalitatea("Brasov");
		dispozitiv.setTrimiteNotificari(true);
		dispozitiv.setStrada("nr 17");
		dispozitiv.setTara("Romania");
		dispozitiv.setName("raspberry");
		dispozitivRepository.save(dispozitiv);
	}

	@Test
	public void insertConsumator1() {
		Consumator bec = new Consumator();
		bec.setCircuit("1");
		bec.setDataOra(new Date());
		bec.setPutereConsumata(500);
		bec.setStare(true);
		bec.setTip("bec");
		consumatorRepository.save(bec);
	}

	@Test
	public void insertConsumator2() {
		Consumator frigider = new Consumator();
		frigider.setCircuit("1");
		frigider.setDataOra(new Date());
		frigider.setPutereConsumata(500);
		frigider.setStare(true);
		frigider.setTip("frigider");
		consumatorRepository.save(frigider);
	}

	@Test
	public void insertConsumator3() {
		Consumator aspirator = new Consumator();
		aspirator.setCircuit("1");
		aspirator.setDataOra(new Date());
		aspirator.setPutereConsumata(500);
		aspirator.setStare(true);
		aspirator.setTip("aspirator");
		consumatorRepository.save(aspirator);
	}

	@Test
	public void insertSenzor1() {
		Senzor lumina = new Senzor();
		lumina.setCircuit("1");
		lumina.setLocatia("Bucatarie");
		lumina.setNume("lumina");
		lumina.setDataOra(new Date());
		lumina.setStare("activ");
		senzorRepository.save(lumina);
	}

	@Test
	public void insertSenzor2() {
		Senzor miscare = new Senzor();
		miscare.setCircuit("1");
		miscare.setLocatia("Bucatarie");
		miscare.setNume("miscare");
		miscare.setDataOra(new Date());
		miscare.setStare("activ");
		senzorRepository.save(miscare);
	}

	@Test
	public void insertNotificare1() {
		Notificare notificare1 = new Notificare();
		notificare1.setCorp("corp notificare 1");
		notificare1.setDataOra(new Date());
		notificare1.setTitlu("notificare1");
		notificareRepository.save(notificare1);
	}

	@Test
	public void insertNotificare2() {
		Notificare notificare2 = new Notificare();
		notificare2.setCorp("corp notificare 2");
		notificare2.setDataOra(new Date());
		notificare2.setTitlu("notificare2");
		notificareRepository.save(notificare2);
	}

	@Test
	public void inserting() {
		Consumator bec = consumatorRepository.getConsumatorByTip("bec");
		Consumator frigider = consumatorRepository.getConsumatorByTip("frigider");
		Consumator aspirator = consumatorRepository.getConsumatorByTip("aspirator");

		Dispozitiv dispozitiv = dispozitivRepository.getDispozitivByName("raspberry");
		
		Senzor lumina = senzorRepository.getSenzorByNume("lumina");
		Senzor miscare = senzorRepository.getSenzorByNume("miscare");
		
		User user1 = userRepository.getUserByNume("User1N");
		User user2 = userRepository.getUserByNume("User2N");

		serviciiDispozitiv.addConsumator(bec, dispozitiv);
		serviciiDispozitiv.addConsumator(frigider, dispozitiv);
		serviciiDispozitiv.addConsumator(aspirator, dispozitiv);
		
		 serviciiDispozitiv.addSenzor(lumina, dispozitiv);
		 serviciiDispozitiv.addSenzor(miscare, dispozitiv);
		
		 
		
		serviciiUser.addDispozitiv(user1, dispozitiv);
		serviciiDispozitiv.addUser(user1, dispozitiv);
		
		serviciiUser.addDispozitiv(user2, dispozitiv);
		serviciiDispozitiv.addUser(user2, dispozitiv);
		
		// for (User book : userRepository.findAll()) {
		// logger.info(book.toString());
		//
		// }

		 for (Dispozitiv book : dispozitivRepository.findAll()) {
		 logger.info(book.toString());
		
		 }

	}

}
