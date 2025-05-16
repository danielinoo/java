package com.spring.esameJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.esameJava.dto.ErroreDTO;
import com.spring.esameJava.dto.prodottoDTO;
import com.spring.esameJava.dto.venditoreDTO;
import com.spring.esameJava.dto.venditoreSPdto;
import com.spring.esameJava.service.venditoreService;


@RestController
@RequestMapping(path = "/venditori")
public class controller {

	@Autowired
	venditoreService service;

	@PostMapping(consumes = "application/json")
	public boolean inserisci(@RequestBody venditoreDTO dto) {
		return service.inserisciVenditore(dto);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public venditoreDTO cercaV(@PathVariable int id) {
		return service.cerca(id);

	}

	@GetMapping(path = "/{id}/venditore", produces = "application/json")
	public venditoreSPdto visualizzaSenzaProdotti(@PathVariable int id) {
		return service.vediSoloVenditore(id);
	}

	@PatchMapping(path = "/{id}/password", produces = "application/json")
	public venditoreDTO modificaP(@PathVariable int id, @RequestParam String password) {

		return service.modificaPassword(id, password);
	}

	@PostMapping(path = "/{id}/prodotti", consumes = "application/json")
	public boolean aggProdotto(@PathVariable int id, @RequestBody prodottoDTO dto) {
		return service.aggprodotto(id, dto);
	}

	@PatchMapping(path = "/{idVenditore}/prodotti/{idProdotto}/quantita")
	public boolean modificaQ(@PathVariable int idVenditore, @PathVariable int idProdotto, @RequestParam int quantita) {
		return service.modificaQuantita(idVenditore, idProdotto, quantita);
	}

	// errori
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> hadler(RuntimeException exc) {
		ErroreDTO error = new ErroreDTO(exc.getMessage());

		ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;

	}
}
