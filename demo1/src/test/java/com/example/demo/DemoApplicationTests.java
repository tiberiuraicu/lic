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
import com.example.demo.repositories.DispozitivRepository;
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

	@Test
	public void inserting() {
		User user = new User();
		user.setEmail("user@user.com");
		user.setLocalitatea("Brasov");
		user.setNumarDeTelefon(0000000000);
		user.setNume("User1N");
		user.setPrenume("User1P");
		user.setRol(new Rol(true, false));
		user.setStrada("nr 17");
		user.setTara("Romania");

		Dispozitiv dispozitiv = new Dispozitiv();
		dispozitiv.setLocalitatea("Brasov");
		dispozitiv.setTrimiteNotificari(true);
		dispozitiv.setStrada("nr 17");
		dispozitiv.setTara("Romania");
		dispozitiv.setName("raspberry");

		Consumator bec = new Consumator();
		bec.setCircuit("1");
		bec.setDataOra(new Date());
		bec.setPutereConsumata(500);
		bec.setStare(true);
		bec.setTip("bec");

		Consumator frigider = new Consumator();
		frigider.setCircuit("1");
		frigider.setDataOra(new Date());
		frigider.setPutereConsumata(500);
		frigider.setStare(true);
		frigider.setTip("frigider");

		Consumator aspirator = new Consumator();
		aspirator.setCircuit("1");
		aspirator.setDataOra(new Date());
		aspirator.setPutereConsumata(500);
		aspirator.setStare(true);
		aspirator.setTip("aspirator");

		Senzor lumina = new Senzor();
		lumina.setCircuit("1");
		lumina.setLocatia("Bucatarie");
		lumina.setNume("lumina");
		lumina.setDataOra(new Date());
		lumina.setStare("activ");

		Senzor miscare = new Senzor();
		miscare.setCircuit("1");
		miscare.setLocatia("Bucatarie");
		miscare.setNume("miscare");
		miscare.setDataOra(new Date());
		miscare.setStare("activ");

		Notificare notificare1 = new Notificare();
		notificare1.setCorp("corp notificare 1");
		notificare1.setDataOra(new Date());
		notificare1.setTitlu("notificare1");

		Notificare notificare2 = new Notificare();
		notificare2.setCorp("corp notificare 2");
		notificare2.setDataOra(new Date());
		notificare2.setTitlu("notificare2");

		serviciiDispozitiv.addConsumator(bec, dispozitiv);
		serviciiDispozitiv.addConsumator(frigider, dispozitiv);
		serviciiDispozitiv.addConsumator(aspirator, dispozitiv);

		serviciiDispozitiv.addSenzor(lumina, dispozitiv);
		serviciiDispozitiv.addSenzor(miscare, dispozitiv);

		

		serviciiUser.addDispozitiv(user, dispozitiv);

		userRepository.save(user);
//
//		for (User book : userRepository.findAll()) {
//			logger.info(book.toString());
//
//		}
		for (User u : userRepository.findAll()) {
			for(Dispozitiv d : u.getDispozitive())
				logger.info(d.toString());

		}
		for (Dispozitiv book : dispozitivRepository.findAll()) {
			logger.info(book.toString());

		}

	}

}
