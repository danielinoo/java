package com.spring.progetto1.service;

import java.util.LinkedList;

import com.spring.progetto1.dto.ListaNomeCognomeDTO;
import com.spring.progetto1.dto.NomeCognomeDTO;
import com.spring.progetto1.dto.UtenteDTO;

public interface UtenteService {
	public Boolean registra(UtenteDTO dto);
	
	public UtenteDTO cercaPerId(int id);
	
	public LinkedList<UtenteDTO> mostraUtenti();
	
	public UtenteDTO rimuoviutente(int idUtDTO);
	
	public NomeCognomeDTO getNomeCgnome(int idUtDTO);
	
	public ListaNomeCognomeDTO tuttiNomiCognomi();
}
