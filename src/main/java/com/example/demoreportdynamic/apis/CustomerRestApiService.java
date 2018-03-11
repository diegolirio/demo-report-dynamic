package com.example.demoreportdynamic.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoreportdynamic.service.Customer;
import com.example.demoreportdynamic.service.CustomerRepository;
import com.example.demoreportdynamic.service.JdbcRepository;
import com.example.demoreportdynamic.service.Params;

@RestController
@RequestMapping
public class CustomerRestApiService {

	@Autowired
	private CustomerRepository customerrepository;
	@Autowired
	private JdbcRepository jdbcRepository;

	@GetMapping
	public Iterable<Customer> findAll() {
		return customerrepository.findAll();
	}
	
	@GetMapping("/s")
	public Iterable<Customer> findAlls(String sql) {
		return jdbcRepository.findByAll(sql);
	}
	
	@GetMapping("/o")
	public ResponseEntity<?> findAllo(String sql) {
		return new ResponseEntity<>(jdbcRepository.findObjectAll(sql), HttpStatus.OK);
	}
	
	@GetMapping("/save")
	public Customer save() {
		Customer customer = Customer.builder().firstname("Diego").lastname("Lirio").build();
		return customerrepository.save(customer );
	}
	
	@GetMapping("/g")
	public String getAll(String sql) {
		jdbcRepository.getAll(sql);
		return "OK";
	}
	
	@PostMapping("/g")
	public String generateReport(@RequestBody Params params) {
		jdbcRepository.getAll(params.getSql());
		return "OK";
	}
	
	
}
