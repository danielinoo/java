package com.spring.esercizio1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "saluto")
public class SalutiController {
	
	//costuttore di deault
	
	//
	public SalutiController() {
		System.out.println("spring istanza SalutiController...");
	}
	
	
	@GetMapping(path= "generico")
	public String salutoGenerico () {
		return "bello zi";
	}
	
	
	@GetMapping(path= "specifico")
	public String salutoPersonalizzato (String nome) {
		return "bello zi " + nome;
	}

}
