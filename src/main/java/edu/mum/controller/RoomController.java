package edu.mum.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.dao.impl.RoomInfoDaoImpl;
import edu.mum.domain.Customer;
import edu.mum.domain.Member;
import edu.mum.domain.Room;
import edu.mum.domain.RoomInfo;
import edu.mum.integration.CustomerGateway;
import edu.mum.service.CustomerService;
import edu.mum.service.RoomInfoService;
import edu.mum.service.RoomService;

@Controller
@RequestMapping({"/rooms"})
public class RoomController {
	
	@Autowired
	private RoomService  roomService;
	
	@Autowired
	private RoomInfoService  roomInfoService;
	
	
	
	
	@Autowired
	private CustomerService  customerService;
	
@Qualifier("customerGate") 
	
	@Autowired 
	CustomerGateway gateway;

	@RequestMapping(value="/display/room")
	public String listRooms() {
//		model.addAttribute("rooms", roomService.getAllRooms());
		
		return "displayRoom";
	}
	
	
	@RequestMapping(value="/display/room", method=RequestMethod.POST)
	public String addRooms(@Valid @DateTimeFormat(pattern="MM/dd/yyyy") Date arrivalDate, @DateTimeFormat(pattern="MM/dd/yyyy") Date departureDate, Model model) {
		
		
		
		
		List<RoomInfo> rooms=roomInfoService.getRoomsByDate(arrivalDate, departureDate);
		System.out.println(arrivalDate);
		System.out.println(departureDate);
		
		
		
		//list of rooms
		for(RoomInfo room: rooms){
//			System.out.println("from Room Controller :" +room.getId()+" "+room.getBedType());
		}
		
		model.addAttribute("rooms",rooms );
		
		return "displayRoom";
	}

	@RequestMapping(value="/room/{id}")
	public String  getCustomerInformation(Model model, @ModelAttribute("newCustomer") Customer customer , @PathVariable("id") long roomid){
		
		model.addAttribute("roomId",roomid);
		
		return "addCustomer";
		
	}
	
	@RequestMapping(value = "/room/{id}", method = RequestMethod.POST)
	public String processAddNewMemberForm(@PathVariable("id") long id, @Valid @ModelAttribute("newCustomer") Customer customerToBeAdded, BindingResult result) {
 
		if(result.hasErrors()) {
			return "addCustomer";
		}
		
		System.out.println(customerToBeAdded.getLastName()+" "+customerToBeAdded.getId());

		//Since it contains a detached object; Customer couldn't be saved to the databses
		Customer cust=new Customer();
		cust.setCustomerNumber(customerToBeAdded.getCustomerNumber());
		cust.setEmail(customerToBeAdded.getEmail());
		cust.setFirstName(customerToBeAdded.getFirstName());
		cust.setLastName(customerToBeAdded.getLastName());
	
	    Room roomRooking=new Room();	     
	    roomRooking.setArrivalDate(customerToBeAdded.getRooms().get(0).getArrivalDate());
	    roomRooking.setDepartureDate(customerToBeAdded.getRooms().get(0).getDepartureDate());
		 
	     RoomInfo rminfo= roomInfoService.findOne(id);		     
	     roomRooking.setRoominfo(rminfo);
		 cust.getRooms().add(roomRooking);
		
		 customerService.save(cust);
		 
		 //Sending an email by passing customer information
		 gateway.process(cust);

		 
	return  "redirect:/rooms/display/room";
	}
	
	
	
//////////////////////
	
	
	@RequestMapping
	public String listRooms(Model model) {
		model.addAttribute("rooms", roomInfoService.getAllRooms());
		return "rooms";
	}
	
  	@RequestMapping("/{id}")
	public String getRoomById(@PathVariable("id") Long id,Model model) {
		Room room = roomService.findOne(id);
		model.addAttribute("room", room);

 		return "room";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewRoom(@ModelAttribute("newRoom") RoomInfo newRoom) {
	   return "addRoom";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewMemberForm(@ModelAttribute("newRoom") @Valid RoomInfo  roomToBeAdded, BindingResult result) {
 
		if(result.hasErrors()) {
			return "addRoom";
		}

			 //  Error caught by ControllerAdvice IF no authorization...
		roomInfoService.save(roomToBeAdded);

	   	return "redirect:/rooms";
 
	}
	
  	
	
	
 
}
