package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Customer;

public interface CustomerDao extends GenericDao<Customer>{
	
	public void fixndCustomerByLastName(String lastname);
	public List<Customer> getCustomerByFirstAndLastName(String first, String last);
	
	
}
