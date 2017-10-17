package edu.mum.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Customer;
import edu.mum.domain.CustomerRoute;
import edu.mum.domain.Member;
import edu.mum.messaging.AMQPMessagingService;
import edu.mum.service.CustomerService;
import edu.mum.service.MemberService;

@Controller
@RequestMapping({"/customers"})
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	
	@Autowired
	AMQPMessagingService amqpMessagingService;

	@RequestMapping
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.findAll());
		return "customers";
	}
	
  	@RequestMapping("/{id}")
	public String getMemberById(@PathVariable("id") Long id,Model model) {
		Customer customer = customerService.findOne(id);
		model.addAttribute("customer", customer);

 		return "customer";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer) {
	   return "addCustomer";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewCustomerForm(@ModelAttribute("newCustomer") Customer customerToBeAdded, BindingResult result) {
 
		if(result.hasErrors()) {
			return "addCustomer";
		}

			 //  Error caught by ControllerAdvice IF no authorization...
		customerService.save(customerToBeAdded);

	   	return "redirect:/customers";
 
	}
	
	@RequestMapping(value="/check")
	public String getChekForm(Model model){
//		model.addAttribute("customers", customerService.getCustomerByFirstAndLastName(String firstName, String lastName));
	
		model.addAttribute("currDate",new Date());
		return "check";
	}
	 
	@RequestMapping(value="/check",method = RequestMethod.POST )
	public String getChekForm(Model model, String firstName, String lastName){
		model.addAttribute("customers", customerService.getCustomerByFirstAndLastName(firstName, lastName));

		return "check";
	}
	
	@RequestMapping(value="/checkout/{id}" )
	public String sendDataToAMQP(@PathVariable("id") long id, Model model){
		
		Customer customer=customerService.findOne(id);
		
		double charge=customer.getRooms().get(0).getRoominfo().getRoomRate();
        String firstName=customer.getFirstName();
        String lastName=customer.getLastName();
        String roomNo=customer.getRooms().get(0).getRoominfo().getRoomNo();
        
        CustomerRoute  route=new CustomerRoute();
        route.setFirstName(firstName);
        route.setLastName(lastName);
        route.setRoomNo(roomNo);
        route.setCharge(charge);
        
       amqpMessagingService.publish(route);
        
        return "rabbitOutput";
	}
	
	
	 
 
}