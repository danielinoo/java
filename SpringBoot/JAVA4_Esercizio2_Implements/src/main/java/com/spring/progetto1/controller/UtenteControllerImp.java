package com.spring.progetto1.controller;


import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.progetto1.dto.ErroreDTO;
import com.spring.progetto1.dto.ListaNomeCognomeDTO;
import com.spring.progetto1.dto.NomeCognomeDTO;
import com.spring.progetto1.dto.UtenteDTO;

import com.spring.progetto1.service.UtenteService;

@RestController
@RequestMapping(path = "/utenti")
public class UtenteControllerImp {

	
	@Autowired
	private UtenteService service;
	


	@PostMapping(path = "/registra", consumes = "application/json")
	public boolean registra(@RequestBody UtenteDTO dto) {
		return service.registra(dto);
	}
	


	@GetMapping(path = "/cerca/{id}", produces = "application/json")
	public UtenteDTO cercaID(@PathVariable int id) {
		return service.cercaPerId(id);
	}


	@GetMapping(path = "/mostraTutti", produces = MediaType.APPLICATION_JSON_VALUE)
	public  LinkedList<UtenteDTO> mostra() {
		LinkedList<UtenteDTO> lista = service.mostraUtenti();
		System.out.println("lista " + lista);
		return lista;
	}
	
//---------------------------------------------------------------------------------------------------
	
	@GetMapping(path = "/elimina/{id}", produces = "application/json")
	public UtenteDTO EliminaUtente(@PathVariable int id) {
		return service.rimuoviutente(id);
		
	}
	
//------------------------------------------------------------------------

	@GetMapping(path = "/cercaNomeCognome/{id}", produces = "application/json")
	public NomeCognomeDTO cercaNomeCognome(@PathVariable int id) {
		return service.getNomeCgnome(id);
	}
	
	//---------------------------------------------------------------------------------------------
	
	@GetMapping(path = "/mostraTuttiNomiCognomi", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ListaNomeCognomeDTO mostraNCC() {
		ListaNomeCognomeDTO lista = service.tuttiNomiCognomi();
		System.out.println("lista " + lista);
		return lista;
	}
	
	
	//per la gestioni degli errori
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> gestore(RuntimeException er) {
		ErroreDTO errore = new ErroreDTO(er.getMessage());
		ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(errore, HttpStatus.NOT_FOUND);
		
		return response;
	}
}
