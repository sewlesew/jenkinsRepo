package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.dao.CustomerDao;
import edu.mum.domain.Customer;
import edu.mum.service.CustomerService;
import edu.mum.service.RoomService;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	

 	@Autowired
	private CustomerDao customerDao;
 	
 	@Autowired
 	RoomService roomService;
 	
 	
	@Override
	public void save(Customer customer) {
		
		customerDao.save(customer);
		
	}

	@Override
	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}

	@Override
	public Customer findOne(Long id) {
		
		return customerDao.findOne(id);
	}

	@Override
	public void update(Customer customer) {
		
		customerDao.update(customer);
	}

	@Override
	public List<Customer> getCustomerByFirstAndLastName(String firstName, String lastName) {
		return customerDao.getCustomerByFirstAndLastName(firstName, lastName);
	
		
	}

	@Override
	public void saveFull(Customer customer) {
	
		
		roomService.save(customer.getRooms().get(0));
		
		customerDao.save(customer);
	}

}
