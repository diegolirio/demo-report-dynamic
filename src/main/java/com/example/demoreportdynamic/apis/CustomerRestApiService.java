package com.example.demoreportdynamic.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoreportdynamic.service.Customer;
import com.example.demoreportdynamic.service.CustomerRepository;

@RestController
@RequestMapping
public class CustomerRestApiService {

	@Autowired
	private CustomerRepository customerrepository;

	@GetMapping
	public Iterable<Customer> findAll() {
		return customerrepository.findAll();
	}
	
}
