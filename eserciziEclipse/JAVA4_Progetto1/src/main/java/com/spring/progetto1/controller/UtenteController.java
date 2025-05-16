package com.spring.progetto1.controller;


import java.util.LinkedList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.progetto1.dto.ListaNomeCognomeDTO;
import com.spring.progetto1.dto.NomeCognomeDTO;
import com.spring.progetto1.dto.UtenteDTO;

import com.spring.progetto1.service.UtenteService;

@RestController
@RequestMapping(path = "/utenti")
public class UtenteController {			//controller --> collegamento con il client

	
	//collegamento con service e richiama i suoi metodi
	private UtenteService service = new UtenteService();
	

//--------------------------------------------------------------------------------------
	
	// per accedere a variabili dentro file json:
	// consumes = "application/json" --> sto specificando che richiede un oggetto
	// json
	// @RequestBody --> dice che la variabile si trova dentro il body

	@PostMapping(path = "/registra", consumes = "application/json")
	public boolean registra(@RequestBody UtenteDTO dto) {
		return service.registra(dto);
	}
	

	
//--------------------------------------------------------------------
	

	// per restituire variabili dentro json
	// path= "/cerca{id}" --> id viaggia dentro il path
	// produces = "application/json" --> invia un file json
	// @PathVariable --> indica al path dove prendere l id

	@GetMapping(path = "/cerca/{id}", produces = "application/json")
	public UtenteDTO cercaID(@PathVariable int id) {
		return service.cercaPerId(id);
	}

//-------------------------------------------------------------------------------------------------------------
	// import org.springframework.http.MediaType;
	// MediaType.APPLICATION_JSON_VALUE --> con questa media type di fa direttamente
	// lui "application/json" come sopra
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
}
