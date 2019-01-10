package com.server.Server.cep.generator;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.Server.cep.handler.LuminaMiscareEventHandler;
import com.server.Server.entites.Intrerupator;
import com.server.Server.entites.Miscare;


/**
 * Just a simple class to create a number of Random TemperatureEvents and pass
 * them off to the TemperatureEventHandler.
 */
@Component
public class LuminaMiscareEventGenerator {



	/**
	 * The TemperatureEventHandler - wraps the Esper engine and processes the Events
	 */
	@Autowired
	private LuminaMiscareEventHandler luminaMiscareEventHandler;

	/**
	 * Creates simple random Temperature events and lets the implementation class
	 * handle them.
	 */
	public void startSendingTemperatureReadings() {
		int i = 0;
		while (true) {
			if (i % 2 == 0) {
				//luminaMiscareEventHandler.handle(new Miscare(0, 1), new Intrerupator(1, 1,"i1"));
				try {
					System.out.println("cu 1");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (i % 2 == 1) {
//				luminaMiscareEventHandler.handle(new Miscare(0, 1), new Intrerupator(0, 1,"i2"));
//				luminaMiscareEventHandler.handle(new Miscare(1, 1), new Intrerupator(1, 1,"i3"));
//				luminaMiscareEventHandler.handle(new Miscare(1, 1), new Intrerupator(1, 1,"i4"));
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
