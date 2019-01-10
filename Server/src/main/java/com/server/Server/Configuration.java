package com.server.Server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.server.Server.cep.generator.AdaugaLaConsumEventGenerator;
import com.server.Server.cep.generator.PrizaNefolositaEventGenerator;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages="com.server.Server")
public class Configuration {

	@Bean
	public AdaugaLaConsumEventGenerator adaugaLaConsumEventGenerator()
	{
		return new AdaugaLaConsumEventGenerator();
	}
	@Bean
	public PrizaNefolositaEventGenerator prizaNefolositaEventGenerator()
	{
		return new PrizaNefolositaEventGenerator();
	}
}
