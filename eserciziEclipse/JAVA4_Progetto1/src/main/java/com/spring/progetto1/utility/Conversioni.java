package com.spring.progetto1.utility;

import com.spring.progetto1.dto.UtenteDTO;
import com.spring.progetto1.entity.Utente;

//converte UtenteDTO in Utente entity e viceversa
public class Conversioni {

	public static Utente da_UtenteDTO_a_Utente(UtenteDTO dto) {
		return new Utente(dto.getId(), dto.getNome(), dto.getCognome(), dto.getUsername(), dto.getPassword());
	}
	
	public static UtenteDTO da_Utentea_UtenteDTO(Utente entity) {
		return new UtenteDTO(entity.getId(),entity.getNome(),entity.getCognome(),entity.getUsername(),entity.getPassword());
	}

}
