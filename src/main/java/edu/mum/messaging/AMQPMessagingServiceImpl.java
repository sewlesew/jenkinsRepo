package edu.mum.messaging;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import edu.mum.domain.CustomerRoute;


@Component
public class AMQPMessagingServiceImpl implements  AMQPMessagingService{

	@Qualifier("amqpTemplate")
	@Autowired
	RabbitTemplate  rabbitTemplate;

	@Override
	public void publish(CustomerRoute Billing) {
		
		rabbitTemplate.convertAndSend(Billing);
	}
	
	
	
}
