package edu.mum.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.mum.domain.CustomerRoute;


public interface AMQPMessagingService {

	
	public void publish(CustomerRoute Billing);
		
	
}
