package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.CustomerDao;

import edu.mum.domain.Customer;


@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

	public CustomerDaoImpl() {
		super.setDaoType(Customer.class );
		}

	@Override
	public void fixndCustomerByLastName(String lastname) {

		  Query query=entityManager.createQuery("select c from Customer where c");
	}

	@Override
	public List<Customer> getCustomerByFirstAndLastName(String first, String last) {
	
		
		Query query=entityManager.createQuery("select c from Customer c where"
				+ " c.firstName=:first and c.lastName=:last");
	List<Customer> customers=(List<Customer>)query.setParameter("first",first).setParameter("last", last).getResultList();
		return customers;
	}
	
	
}
