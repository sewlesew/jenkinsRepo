package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.service.impl.RestService;

 @Controller
 @RequestMapping("/services")
 public class RestController {

	@Autowired
	RestService service;
	
	@RequestMapping(value="/all")
	public String listRooms(Model model) {
		model.addAttribute("services", service.getData());
		
		return "services";
	}
}
