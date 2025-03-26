package com.spring.esercizio4Studenti.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.esercizio4Studenti.dto.StudenteDTO;
import com.spring.esercizio4Studenti.service.serviceStudenti;

@RestController
@RequestMapping(path = "/studenti")
public class controller {
	
	@Autowired
	private serviceStudenti service;
	
	
	
	@PostMapping( consumes = "application/json")
	public boolean inserici(@RequestBody StudenteDTO dto) {
		return service.immatricola(dto);
	}
	
	
	@GetMapping(path = "/{matricola}",produces = "application/json")
	public StudenteDTO cerca(@PathVariable  int matricola) {
		return service.cerca(matricola);
	}
	
	
	@GetMapping(path = "/tutti",produces = "application/json")
	public LinkedList<StudenteDTO> visualizza(){
		return service.visualizza();
	}
	
	@DeleteMapping(path = "/{matricola}",produces = "application/json")
	public StudenteDTO delete(@PathVariable int matricola) {
		return service.elimina(matricola);
	}
	
	@GetMapping(path = "/giovani",produces = "application/json")
	public List<StudenteDTO> getGiovani(int annoImm){
		return service.getGiovani(annoImm);
	}
	
}
