package com.server.Server.receiver;


import org.apache.log4j.Logger;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.server.Server.cep.generator.AdaugaLaConsumEventGenerator;
import com.server.Server.cep.generator.PrizaNefolositaEventGenerator;

@Configuration
@ComponentScan(basePackages="com.server.Server")
//@PropertySource("classpath:config.properties")
public class ReceiverConfiguration {
//	@Value("${factory.host}")
//	String host;
//	@Value("${rabbit.username}")
//	String rabbitUsername;
//	@Value("${rabbit.password}")
//	String rabbitPassword;
//	@Value("${queue.procesor}")
//	String queueProcesor;
//	@Value("${queue.alarma}")
//	String queueAlarma;
//	@Value("${exchange}")
//	String exchange;
//	@Value("${alarm.key}")
//	String alarmKey;
//	@Value("${procesor.key}")
//	String procesorKey;

	final static Logger logger = Logger.getLogger(ReceiverConfiguration.class);

	

//		@Bean
//		public CachingConnectionFactory connectionFactory() {
//			CachingConnectionFactory conn = new CachingConnectionFactory();
//
//			conn.setHost(host);
//			conn.setUsername(rabbitUsername);
//			conn.setPassword(rabbitPassword);
//			return conn;
//
//		}
//
//		@Bean
//		public RabbitTemplate templateGet() {
//			RabbitTemplate template = new RabbitTemplate();
//			template.setConnectionFactory(connectionFactory());
//			return template;
//		}
//
//		@Bean
//		@Qualifier("queueProcesor")
//		public Queue queueProcesor() {
//			return new Queue(queueProcesor);
//		}
//
////		@Bean
////		@Qualifier("queueAlarm")
////		public Queue queueAlarm() {
////			return new Queue(queueAlarma);
////		}
//
//		@Bean
//		public DirectExchange exchange() {
//			return new DirectExchange(exchange);
//		}
//
//		@Bean
//		public Binding bindingProcesor(DirectExchange exchange, Queue queueProcesor) {
//			return BindingBuilder.bind(queueProcesor).to(exchange).with(procesorKey);
//		}
//
////		@Bean
////		public Binding bindingAlarma(DirectExchange exchange, Queue queueAlarm) {
////			return BindingBuilder.bind(queueAlarm).to(exchange).with(alarmKey);
////		}
//
//		@Bean
//		public Receiver receiver() {
//			return new Receiver();
//		}
//		
//		
		
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