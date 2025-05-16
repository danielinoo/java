package com.spring.progetto3.studente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.progetto3.studente.dto.CognomeAnnoStudenteDTO;
import com.spring.progetto3.studente.dto.CognomeImmatricolazioneSTUDENTEdto;
import com.spring.progetto3.studente.dto.StudenteDTO;
import com.spring.progetto3.studente.service.StudenteService;


@RestController
@RequestMapping(path = "/studenti")
public class Studente_CONTROLLERImp {

	
	@Autowired
	private StudenteService service;

	@PostMapping(path = "/inserisciStudente", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean carica(@RequestBody StudenteDTO dto) {
		return service.InserimentoStudente(dto);
	}

	@GetMapping(path = "/cercaStudente/{matricola}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudenteDTO cercaMatricola(@PathVariable int matricola) {
		return service.cercaMatricola(matricola);
	}

	@GetMapping(path = "/TuttiStudenti", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudenteDTO> listastu() {
		return service.mostraStudenti();
	}

	@GetMapping(path = "/RimuoviStudente/{matricola}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudenteDTO rimuovoiID(@PathVariable int matricola) {
		return service.rimuoviStudente(matricola);
	}

	@GetMapping(path = "/modificaIndirizzo/{matricola}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudenteDTO modificaMat(@PathVariable  int matricola,String indirizzo) {
		return service.modificaIndirizzo(matricola, indirizzo);

	}
	
	
	@GetMapping(path = "/TuttiNomiStudenti",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> listanomi() {
		return service.mostraNomiStudenti();
	}
	
	@GetMapping(path = "/StudenteGiovane",  produces = MediaType.APPLICATION_JSON_VALUE)
	public CognomeAnnoStudenteDTO giovane() {
		return service.studenteGiovane();
	}		
	
	@GetMapping(path = "/StudenteIscrittoPiuTempo",  produces = MediaType.APPLICATION_JSON_VALUE)
	public CognomeImmatricolazioneSTUDENTEdto piuTempo() {
		return service.studentePiuIscritto();
	}

}
