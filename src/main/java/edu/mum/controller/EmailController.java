package edu.mum.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.domain.Customer;
import edu.mum.integration.CustomerGateway;

@Controller
@RequestMapping("/email")
public class EmailController {
//	
	@Qualifier("customerGate") 	
	
	@Autowired 
	CustomerGateway rabbitTemplate;
	
	
	
	@RequestMapping("/alert")
	public String TemplateForm(){
		
		
//		ApplicationContext context=new ClassPathXmlApplicationContext("context/amqp-order-app-context.xml");
//	RabbitTemplate rabbitTemplate=(RabbitTemplate)context.getBean("amqpTemplate",RabbitTemplate.class);
		
		
//		ApplicationContext context=new ClassPathXmlApplicationContext(	new String[]{		
//	 		"/context/roomGateway-context.xml",
//			"/context/mailContext.xml"});
		
//		ApplicationContext context=new ClassPathXmlApplicationContext("roomGateway.xml");	
	
//		CustomerGateway rabbitTemplate=(CustomerGateway)context.getBean("customerGate");
		
	Customer customer=new Customer();
	customer.setFirstName("SEWLESEW YAREGAL MESEGANAW");
	customer.setEmail("yaregal.sewlesew@gmail.com");
	
	rabbitTemplate.process(customer);
	
	return "ealert";
	}

}
