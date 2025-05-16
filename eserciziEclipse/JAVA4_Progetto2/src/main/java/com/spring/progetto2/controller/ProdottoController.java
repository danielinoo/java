package com.spring.progetto2.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.progetto2.dto.ProdottoDTO;
import com.spring.progetto2.dto.ProdottoNoIdDTO;
import com.spring.progetto2.dto.ReportDTO;
import com.spring.progetto2.service.ProdottoService;

@RestController
@RequestMapping(path = "/prodotti")
public class ProdottoController {
	
	private ProdottoService service = new ProdottoService();
	
	
	
	@PostMapping(path = "/inserisciProdotto", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean carica(@RequestBody ProdottoDTO dto) {
		return service.CaricamentoProdotto(dto);
	}
	
	@GetMapping(path = "/cerca/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProdottoDTO cercaID(@PathVariable int id) {
		return service.cercaProdottoId(id);
	}
	
	
	@GetMapping(path = "/TuttiProdottiSenzaID", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProdottoNoIdDTO> cercaSenzaId() {
		return service.cercaProdottiSenzaId();
	}
	
	@GetMapping(path = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
	public ReportDTO cercaReport() {
		return service.repProdotti();
	
	}
	
	
	
	
	

}
