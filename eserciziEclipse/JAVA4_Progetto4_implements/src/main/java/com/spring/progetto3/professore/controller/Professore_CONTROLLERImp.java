package com.spring.progetto3.professore.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.progetto3.professore.dto.ProfessoreDTO;
import com.spring.progetto3.professore.service.ProfService;

@RestController
@RequestMapping(path = "/professori")
public class Professore_CONTROLLERImp {

	private ProfService service;

	@PostMapping(path = "/inserisciProf", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean carica(@RequestBody ProfessoreDTO dto) {
		return service.InserimentoProf(dto);
	}

	@GetMapping(path = "/cercaProf/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessoreDTO cercaID(@PathVariable int id) {
		return service.cercaProfId(id);
	}

	@GetMapping(path = "/TuttiProf", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProfessoreDTO> listaprof() {
		return service.mostraProfessori();
	}

	@GetMapping(path = "/RimuoviProf/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessoreDTO rimuovoiID(@PathVariable int id) {
		return service.rimuoviProf(id);
	}

	@GetMapping(path = "/modificaMateria/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfessoreDTO modificaMat(@PathVariable int id, String materia) {
		return service.modificaMateria(id, materia);

	}

}
