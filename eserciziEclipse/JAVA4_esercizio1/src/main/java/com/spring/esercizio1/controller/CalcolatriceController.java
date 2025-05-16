package com.spring.esercizio1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica a Srrping che dovrà istanziare e gestire questa classe
@RequestMapping(path = "/calcolatrice") //@RequestMapping --> consente di mappare un metodo di un controller a una richiesta HTTP specifica. path = "/calcolatrice" --> primo pezzo di url
public class CalcolatriceController {

	// qui costruttore di default

	
	
	
	//http://localhost:8080/calcolatrice/som?a=10&b=5
	@GetMapping(path = "/som")    //path = "/som" --> secondo pezzo che si va ad unire col pezzo di path di sopra
	public int somma(int a, int b) {
		return a + b;
	}
	
	@GetMapping(path = "/sott")   
	public int sottrazione(int a, int b) {
		return a - b;
	}
	
	
	@GetMapping(path = "/molt")   
	public int moltiplicazione(int a, int b) {
		return a * b;
	}
}
