package com.spring.progetto5.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.progetto5.dto.ContattiProprietario;
import com.spring.progetto5.dto.ContattoDTO;
import com.spring.progetto5.dto.ErroreDTO;
import com.spring.progetto5.dto.NomeCognomeContattoDTO;
import com.spring.progetto5.dto.ProprietariNumero;
import com.spring.progetto5.dto.ProprietarioAnnoDTO;
import com.spring.progetto5.dto.RubricaDTO;
import com.spring.progetto5.service.serviceRubricaContatti;

@RestController
@RequestMapping(path = "/rubrica")
public class ControllerApp {

	@Autowired
	private serviceRubricaContatti service;

	// inserisci
	@PostMapping(path = "/nuova", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean Inserisci(@RequestBody RubricaDTO dto) {
		return service.InserisciRubrica(dto);

	}

	// cerca per id
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO cercaRubrica(@PathVariable int id) {
		return service.cercaRubricaId(id);
	}

	// visualizzatutte le rubriche
	@GetMapping(path = "/Rubriche", produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedList<RubricaDTO> mostraTutteRubriche() {
		return service.mostraRubriche();

	}

	// elimina rubrica
	@DeleteMapping(path = "/{idrDTO}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO eliminaRubrica(@PathVariable int idrDTO) {

		return service.rimuoviRubrica(idrDTO);
	}

	// visualizza solo proprietario e anno
	@GetMapping(path = "/{id}/proprietario/anno", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProprietarioAnnoDTO VisualizzaProprietarioAnno(@PathVariable int id) {
		return service.VisualizzaAnnoProprietario();
	}

	// modifica ANNOCreazione
	@PatchMapping(path = "/{idRubrica}/{nuovoAnno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public RubricaDTO modificaAnno(@PathVariable int idRubrica, @PathVariable int nuovoAnno) {
		return service.modificaAnnoCreazione(idRubrica, nuovoAnno);
	}

	// tutti i nomi dei proprietari e il loro numero totale
	@GetMapping(path = "/proprietari", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProprietariNumero Proprietari() {
		return service.TuttiProprietari();
	}

	// visualizza proprietario e anno creazione piu vecchia
	@GetMapping(path = "/AnnoPiuVecchio", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProprietarioAnnoDTO AnnoProprietario() {
		return service.VisualizzaAnnoProprietario();
	}

	// visualizza tutti gli anni di creazione in ordine crescente
	@GetMapping(path = "/anni", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Integer> AnniRubriche() {
		return service.AnniCreazione();
	}

	// visualizza nome del proprietario e il numero contatti di una rubrica
	@GetMapping(path = "/{id}/proprietario/numero", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContattiProprietario ContattiProp(@PathVariable int id) {

		return service.ContProp(id);
	}

	// -----------------------------------------------------------------------------------------

	// inserisci nuovo Contatto
	@PostMapping(path = "/{id}/contatti/nuovo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean InsContatto(@PathVariable int id, @RequestBody ContattoDTO dto) {
		return service.InseriscContatto(id, dto);
	}

	// visualizza un contatto per id
	@GetMapping(path = "/{id}/contatti/{IDcontatto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContattoDTO cercaConta(@PathVariable int id, @PathVariable int IDcontatto) {
		return service.cercaContatto(id, IDcontatto);
	}

	// Modifica Contatto esistente (tutti campi tranne id)
	@PutMapping(path = "/{id}/contatti/contatto", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContattoDTO modificaContatto(@PathVariable int id, @RequestBody ContattoDTO dto) {
		return service.modificaContatto(id, dto);

	}

	// elimina contatto esistente
	@DeleteMapping(path = "/{id}/contatti/{IDcontatto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContattoDTO eliminaContatto(@PathVariable int id, @PathVariable int IDcontatto) {
		return service.eliminaContatto(id, IDcontatto);
	}

	// visualizza tutti i contatti
	@GetMapping(path = "/{id}/contatti/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedList<ContattoDTO> VisualizzaContattiRubrica(@PathVariable int id) {
		return service.VisualizzaContatti(id);
	}

	// visualizza numero di contatti
	@GetMapping(path = "/{id}/contatti/NumeroContatti", produces = MediaType.APPLICATION_JSON_VALUE)
	public int NumeroContattiRubrica(@PathVariable int id) {
		return service.VisualizzaNUmeroContatti(id);
	}

	// cerca numero
	@GetMapping(path = "/{id}/contatti", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContattoDTO cercaNumRubrica(@PathVariable int id, String num) {

		return service.cercaNumero(id, num);

	}

	// nome e cognome dato un gruppo
	@GetMapping(path = "/{id}/contatti/gruppo", produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedList<NomeCognomeContattoDTO> cercaNomCogn(@PathVariable int id,String gruppo) {

		return service.ListaNomeCognome(id, gruppo);
	}

	// ricerca numero di contatti di un dato gruppo
	@GetMapping(path = "/{id}/contatti/{gruppo}/numero", produces = MediaType.APPLICATION_JSON_VALUE)
	public int NumeroContattiGruppo(@PathVariable int id, @PathVariable String gruppo) {
		return service.NumeroContattiGruppo(id, gruppo);
	}

	// cancella gruppo (tutti i contatti appartenenti)
	@DeleteMapping(path = "/{id}/contatti/gruppo", produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedList<ContattoDTO> ListaContattiEliminati(@PathVariable int id, String  gruppo) {
		return service.ListaContattiEliminati(id, gruppo);

	}

	// modifica contatto da non preferito a preferito
	@PatchMapping(path = "/{id}/contatti/{IDcontatto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContattoDTO modificaPreferito(@PathVariable int id, @PathVariable int IDcontatto) {
		return service.modificaPreferito(id, IDcontatto);

	}

	// lista preferiti
	@GetMapping(path = "/{id}/contatti/ListaPreferiti", produces = MediaType.APPLICATION_JSON_VALUE)
	public LinkedList<ContattoDTO> ListaPreferiti(@PathVariable int id) {
		return service.ListaPreferiti(id);

	}

	// errori
	@ExceptionHandler
	public ResponseEntity<ErroreDTO> hadler(RuntimeException exc) {
		ErroreDTO error = new ErroreDTO(exc.getMessage());

		ResponseEntity<ErroreDTO> response = new ResponseEntity<ErroreDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;

	}
}
