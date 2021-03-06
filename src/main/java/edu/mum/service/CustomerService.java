package edu.mum.service;

import java.util.List;

import edu.mum.domain.Customer;


public interface CustomerService {
	public void save(Customer customer);
//    public void saveFull( Customer customer);  		

	public List<Customer> findAll();
 	public Customer findOne(Long id);
 	
 	public void saveFull(Customer customer);
 	
 	
 	public void update(Customer customer);
 	public List<Customer>  getCustomerByFirstAndLastName(String firstName, String lastName);
}
