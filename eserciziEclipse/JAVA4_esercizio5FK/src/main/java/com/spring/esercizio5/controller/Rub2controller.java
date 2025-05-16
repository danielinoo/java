package com.spring.esercizio5.controller;

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

import com.spring.esercizio5.dto.ErroreDTO;
import com.spring.esercizio5.dto.contattoDTO;
import com.spring.esercizio5.dto.rubricaDTO;
import com.spring.esercizio5.service.Rub2service;

@RestController
@RequestMapping(path = "rubriche")
public class Rub2controller {
	
	@Autowired
	private Rub2service service;

	
	@PostMapping(consumes = "application/json")
	public boolean crea(@RequestBody rubricaDTO dto) {
		return service.creaRubrica(dto);
	}
	
	@GetMapping(path = "/{id}",produces = "application/json")
	public rubricaDTO cerca(@PathVariable int id) {
		return service.cerca(id);
	}
	
	
	
	@PostMapping(path = "/{id}/contatti", consumes =  "application/json")
	public boolean aggiungiContatto(@PathVariable int id,@RequestBody contattoDTO dto) {
		return service.aggContatto(id, dto);
	}
	
	@GetMapping(path = "/tutti",produces = "application/json")
	public List<rubricaDTO> tutteRubriche(){
		return service.mostraRubriche();
	}
	
	@DeleteMapping(path = "/{id}",produces = "application/json")
	public rubricaDTO eliminaRubrica(@PathVariable int id) {
		return service.rimuoviRubrica(id);
	}
	
	@GetMapping(path = "/{id}/contatti/{id2}",produces = "application/json")
	public contattoDTO cercaContatto(@PathVariable int id, @PathVariable int id2) {
		return service.cercaContatto(id,id2);
	}
	
	@DeleteMapping(path = "/{id}/contatti/{id2}",produces = "application/json")
	public contattoDTO eliminaContatto(@PathVariable int id, @PathVariable int id2) {
		return service.eliminaContatto(id, id2);
	}
	
	@GetMapping(path = "/{id}/contatti/tutti",produces = "application/json")
	public List<contattoDTO> tuttiContatti(@PathVariable int id){
		return service.VisualizzaContatti(id);
	}
	
	@PatchMapping(path = "/{id}/{anno}",produces = "application/json")
	public rubricaDTO modificaAnno(@PathVariable int id, @PathVariable int anno){
		return service.modificaAnnoCreazione(id, anno);
		
	}
	
	// errori
		@ExceptionHandler
		public ResponseEntity<ErroreDTO> hadler(RuntimeException exc) {
			ErroreDTO error = new ErroreDTO(exc.getMessage());

			ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;

		}
	
	
	
}

