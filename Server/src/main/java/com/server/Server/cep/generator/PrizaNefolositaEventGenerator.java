package com.server.Server.cep.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.Server.cep.handler.PrizaNefolositaEventHandler;
import com.server.Server.entites.Priza;

/**
 * Just a simple class to create a number of Random TemperatureEvents and pass
 * them off to the TemperatureEventHandler.
 */
@Component
public class PrizaNefolositaEventGenerator {



	/**
	 * The TemperatureEventHandler - wraps the Esper engine and processes the Events
	 */
	@Autowired
	private PrizaNefolositaEventHandler prizaNefolositaEventHandler;

	/**
	 * Creates simple random Temperature events and lets the implementation class
	 * handle them.
	 */
	public void startSendingTemperatureReadings() {
		int i = 0;
		while (true) {
			if (i % 2 == 0) {
//				prizaNefolositaEventHandler.handle(new Priza(52.6,1,"p1"));
//				prizaNefolositaEventHandler.handle(new Priza(55.6,1,"p1"));
//				prizaNefolositaEventHandler.handle(new Priza(58.6,1,"p1"));
				try {
					System.out.println("cu 1");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i % 2 == 1) {
//				prizaNefolositaEventHandler.handle(new Priza(0.2,1,"p2"));
//				prizaNefolositaEventHandler.handle(new Priza(0.2,1,"p3"));
//				prizaNefolositaEventHandler.handle(new Priza(0.2,1,"p4"));


				try {
					System.out.println("cu 0");
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
