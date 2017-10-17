package edu.mum.integration;

import org.springframework.integration.annotation.Gateway;

import edu.mum.domain.Customer;


public interface CustomerGateway {
	@Gateway(requestChannel="fromCustomerGateway")
	public void process(Customer customer);
}
