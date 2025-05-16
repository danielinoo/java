package com.spring.esercizio1.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data")
public class Datacontroller {
	
	@GetMapping(path = "dc")
	public LocalDate DataCorrente() {
		return LocalDate.now();
		
	}

}
