package edu.mum.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.HotelService;
import edu.mum.domain.Room;

@Component
public class RestService {

	public List<HotelService> getData(){
		String url="http://localhost:8080/HotelRestService/services/all";	

		
		RestTemplate restTemplate = new RestTemplate();
		
		//restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    HttpHeaders requestHeaders = new HttpHeaders();    
	    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	    
	     
	    HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
	    ResponseEntity<HotelService[]> responseEntity =     restTemplate.exchange(url, HttpMethod.GET, requestEntity, HotelService[].class);
	   
	    
	    
	    
	    
	    
	    
		return Arrays.asList(responseEntity.getBody());
		
		
		
	}
	
}
