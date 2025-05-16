package com.spring.progetto6.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.progetto6.dto.ErroreDTO;
import com.spring.progetto6.dto.NomeCognomeDTO;
import com.spring.progetto6.dto.impiegatoDTO;

import com.spring.progetto6.service.ImpiegatiService;

@RestController
@RequestMapping(path = "/impiegati")
public class Impcontroller {
	
	@Autowired
	ImpiegatiService service;
	
	@PostMapping(consumes = "application/json")
	public boolean inserisci( @RequestBody impiegatoDTO dto) {
		return service.assumi(dto);
	}
	
	@GetMapping(path = "/{m}" ,produces = "application/json")
	public impiegatoDTO cerca(@PathVariable int m) {
		return service.cerca(m);
	}
	
	@GetMapping(path = "/tutti",produces = "application/json")
	public List<impiegatoDTO> visualizza(){
		return service.visualizza();
	}
	
	@DeleteMapping(path = "/{m}" ,produces = "application/json")
	public impiegatoDTO elimina( @PathVariable  int m) {
		return service.elimina(m);
	}
	
	@PatchMapping(path= "/{m}/salario" ,produces = "application/json")
	public impiegatoDTO modifica(@PathVariable int m, double salario) {
		return service.modifica(m, salario);
	}
	
	
	//elimina e ritorna nome cognome
	@DeleteMapping(path = "/nc/{m}" ,produces = "application/json")
	public NomeCognomeDTO eliminaNC( @PathVariable  int m) {
		return service.eliminaNC(m);
	}
	
	//lista nome cognome
	@GetMapping(path = "/nc/tutti",produces = "application/json")
	public List<NomeCognomeDTO> visualizzaNC(){
		return service.visualizzaNC();
	}
	
	//lista impiegati con salari maggiore dato un salario
	@GetMapping(path = "/salario/{s}" ,produces = "application/json")
	public List<impiegatoDTO> cerca(@PathVariable double s) {
		return service.listaSalariMag(s);
	}

	//tutti impiegati ordinati per cognome
	@GetMapping(path = "/cognome/tutti",produces = "application/json")
	public List<impiegatoDTO> visualizzaPecognome(){
		return service.visualizzaPeCognome();
	}
	
	
	

	
	//tutti impiegati ordinati pe salario
	@GetMapping(path = "/salario/tutti",produces = "application/json")
	public List<impiegatoDTO> visualizzaPeSalario(){
		return service.visualizzaPeSalario();
	}
	
	// errori
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> hadler(RuntimeException exc) {
		ErroreDTO error = new ErroreDTO(exc.getMessage());

		ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;

	}
	
}
