package com.server.Server.cep.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.Server.cep.handler.AdaugaLaConsumEventHandler;
import com.server.Server.entites.Consumator;
import com.server.Server.entites.Intrerupator;
import com.server.Server.entites.Priza;

/**
 * Just a simple class to create a number of Random TemperatureEvents and pass
 * them off to the TemperatureEventHandler.
 */
@Component
public class AdaugaLaConsumEventGenerator {

	/**
	 * The TemperatureEventHandler - wraps the Esper engine and processes the Events
	 */
	@Autowired
	private AdaugaLaConsumEventHandler adaugaLaConsumEventHandler;

	/**
	 * Creates simple random Temperature events and lets the implementation class
	 * handle them.
	 */
	public void startSendingTemperatureReadings() {

		int i = 0;
		while (true) {
			if (i % 2 == 0) {
				Consumator unu = new Priza();
				unu.setPutereConsumata(0.2);
				unu.setStare(1);
				unu.setNume("p2");
				Consumator doi = new Priza();
				doi.setPutereConsumata(55.6);
				doi.setStare(1);
				doi.setNume("p2");
				Consumator trei = new Priza();
				trei.setPutereConsumata(58.6);
				trei.setStare(1);
				trei.setNume("p2");
				Consumator treiprim = new Priza();
				trei.setPutereConsumata(60.6);
				trei.setStare(1);
				trei.setNume("p2");
				adaugaLaConsumEventHandler.handle(unu);
				adaugaLaConsumEventHandler.handle(doi);
				adaugaLaConsumEventHandler.handle(trei);
				adaugaLaConsumEventHandler.handle(treiprim);

				try {

					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i % 2 == 1) {
				Consumator unu = new Intrerupator();
				unu.setPutereConsumata(0.2);
				unu.setStare(1);
				unu.setNume("i1");
				Consumator doi = new Intrerupator();
				doi.setPutereConsumata(55.6);
				doi.setStare(1);
				doi.setNume("i2");
				Consumator trei = new Intrerupator();
				trei.setPutereConsumata(58.6);
				trei.setStare(1);
				trei.setNume("i3");
				adaugaLaConsumEventHandler.handle(unu);
				adaugaLaConsumEventHandler.handle(doi);
				adaugaLaConsumEventHandler.handle(trei);

				try {

					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			i++;
		}

	}

}
