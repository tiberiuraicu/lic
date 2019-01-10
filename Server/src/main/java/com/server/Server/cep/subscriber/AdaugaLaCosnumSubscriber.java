package com.server.Server.cep.subscriber;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.server.Server.cep.processing.FnctiiAjutor;
import com.server.Server.database.repositories.ConsumatorRepository;
import com.server.Server.entites.Alimentator;
import com.server.Server.entites.Circuit;
import com.server.Server.entites.Consumator;
import com.server.Server.entites.PanouSolar;

@Component
public class AdaugaLaCosnumSubscriber {
	@Autowired
	private ConsumatorRepository consumatorRepository;
FnctiiAjutor fnctiiAjutor= new FnctiiAjutor();

public String getStatement() {

// Example using 'Match Recognise' syntax.
String crtiticalEventExpression = "select * from Consumator "
        + "match_recognize ( "
        + "       measures A as intrerupator1, B as intrerupator2, C as intrerupator3 "
        + "       pattern (A B C) " 
        + "       define "
        + "               A as A.putereConsumata >= " + 0.0 + ", "
        + "               B as (A.putereConsumata < B.putereConsumata) "
        + ")";

return crtiticalEventExpression;
}

	/**
	 * Listener method called when Esper has detected a pattern match.
	 */
	public void update(Map<String, Consumator> eventMap) {
	
		
		Consumator a = eventMap.get("intrerupator3");
        System.out.println(a.getPutereConsumata()+"--------------------------------------------------");

		Consumator con=consumatorRepository.findByNume(a.getNume());
		Consumator x= new Consumator();
		x=con;
		con.setPutereConsumata(a.getPutereConsumata());
		consumatorRepository.save(con);
		x.setPutereConsumata(1);
		consumatorRepository.save(x);
		
		Circuit circuit=con.getCircuit();
		
		Alimentator alimentator=  circuit.getAlimentator();

		if(alimentator.getClass().equals(PanouSolar.class)) {
		
			fnctiiAjutor.verificareMarireConsum((PanouSolar)alimentator);
		}
		

	}

}
