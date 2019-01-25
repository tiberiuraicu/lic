package com.server.Server.receiver;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.server.Server.cep.handler.AdaugaLaConsumEventHandler;
import com.server.Server.entites.Consumator;
import com.server.Server.entites.Priza;

@Component
public class Receiver {

	@SuppressWarnings("unused")
	@Autowired
	private RabbitTemplate template;
	@SuppressWarnings("unused")
	@Autowired
	private DirectExchange exchange;

	AdaugaLaConsumEventHandler adaugaLaConsumEventHandler = new AdaugaLaConsumEventHandler();
	ObjectMapper mapper = new ObjectMapper();
	final static Logger logger = Logger.getLogger(Receiver.class);

	@RabbitListener(queues = "Procesor")
	public String procesorDataReceiver(byte[] body) throws Exception {
		try {

			String procesorMessage = new String(body, "UTF-8");
			JsonObject procesorDataAsJson = parsare_json(procesorMessage);
			if(procesorDataAsJson.get("tip").toString()=="priza")
			{
//				Consumator consumator = new Priza();
//				consumator.setDataOra(procesorDataAsJson.get("timestamp").toString());
//				consumator.setNume(procesorDataAsJson.get("nume").toString());
//				consumator.setPutereConsumata(putereConsumata);
//				Priza priza= mapper.readValue(procesorMessage, Priza.class);
//				adaugaLaConsumEventHandler.handle(priza);
			}

			

			logger.info("date procesor primite cu succes");
		} catch (Exception e) {
			logger.error("eroare in primirea datelor pentru procesor");
		}
		return "merge";
	}

	private static JsonObject parsare_json(String dateProcesor) {
		JsonParser jsonParser = new JsonParser();
		JsonObject procesorDataAsJson = (JsonObject) jsonParser.parse(dateProcesor).getAsJsonObject();

		return procesorDataAsJson;
	}

	// @RabbitListener(queues = "Alarm")
	// public String alarmDataReceiver(byte[] body) throws
	// UnsupportedEncodingException {
	// DataProcess dataProcess = new DataProcess();
	// String alarmMessage = new String(body, "UTF-8");
	// dataProcess.alarmDataProcess(alarmMessage);
	// return "merge";
	// }

}