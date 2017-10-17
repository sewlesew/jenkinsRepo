package edu.mum.amqp;

import edu.mum.domain.CustomerRoute;



public class ItemListener {	
	
	
public void listen(CustomerRoute route){
		
		System.out.println("Customer information :  ");
		System.out.println(route.getFirstName());
		System.out.println(route.getLastName());
		System.out.println(route.getRoomNo());
		System.out.println(route.getCharge());
		
		
	}
}
