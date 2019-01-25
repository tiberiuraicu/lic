package rabbitMQSenderWithSpring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.Server.entites.Consumator;
import com.server.Server.entites.Priza;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class DataInfoSender {
	@Autowired
	RabbitTemplate template;
	@Autowired
	DirectExchange exchange;

	public void sendData() throws JsonProcessingException, InterruptedException {
		String csvFile = "testFillipo.csv";
		String line = "";
		String cvsSplitBy = ",";
		ObjectMapper mapper = new ObjectMapper();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);
				System.out.println(country[1].toString() + " ffffff");
				Consumator unu = new Priza();

				if (country[1].isEmpty()) {
					unu.setPutereConsumata(10.0);
				System.out.println("intra");
				}
				else
					unu.setPutereConsumata(Double.parseDouble(country[1]));
				String unuJ = mapper.writeValueAsString(unu);
				String unur = (String) this.template.convertSendAndReceive(this.exchange.getName(), "procesor_key",
						unuJ.toString().getBytes());
				Thread.sleep(500);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Object to JSON in String
		// Consumator unu = new Priza();
		// unu.setPutereConsumata(0.2);
		// unu.setStare(1);
		// unu.setNume("p1");
//		Consumator doi = new Priza();
//		doi.setPutereConsumata(55.6);
//		doi.setStare(1);
//		doi.setNume("p2");
//		Consumator trei = new Priza();
//		trei.setPutereConsumata(58.6);
//		trei.setStare(1);
//		trei.setNume("p3");
//		trei.setIdDispozitiv(1);
//
//		Consumator treiprim = new Priza();
//		trei.setPutereConsumata(60.6);
//		trei.setStare(1);
//		trei.setNume("p4");
//
//		String doiJ = mapper.writeValueAsString(doi);
//		String treiJ = mapper.writeValueAsString(trei);
//		String treiPrimJ = mapper.writeValueAsString(treiprim);

		// String unur = (String)
		// this.template.convertSendAndReceive(this.exchange.getName(), "procesor_key",
		// unuJ.toString().getBytes());
		// String doir = (String)
		// this.template.convertSendAndReceive(this.exchange.getName(), "procesor_key",
		// doiJ.toString().getBytes());
		// String treir = (String)
		// this.template.convertSendAndReceive(this.exchange.getName(), "procesor_key",
		// treiJ.toString().getBytes());
		// String treiprimR = (String)
		// this.template.convertSendAndReceive(this.exchange.getName(), "procesor_key",
		// treiPrimJ.toString().getBytes());
		//
		System.out.println(" [.] Got '" + "" + "'");
		Thread.sleep(500);

	}
}
