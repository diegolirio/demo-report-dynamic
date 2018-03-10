package com.example.demoreportdynamic.service;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	private Long id;
	
	private String firstname, lastname;
}
