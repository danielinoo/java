package com.spring.progetto1.service;

import java.util.LinkedList;
import java.util.List;

import com.spring.progetto1.dao.DAOtenteMappa;
import com.spring.progetto1.dto.ListaNomeCognomeDTO;
import com.spring.progetto1.dto.NomeCognomeDTO;
import com.spring.progetto1.dto.UtenteDTO;
import com.spring.progetto1.entity.Utente;
import com.spring.progetto1.utility.Conversioni;

//converte i dati passati in formato DTO a entity
//e si collega con il dao
public class UtenteService {

	// fa un collegamento con il dao(in questo caso il dao è anche il database) e fa
	// una mappa vuota dentro il dao
	private DAOtenteMappa dao = new DAOtenteMappa();

	public Boolean registra(UtenteDTO dto) {

		// 1.trasformo il dto in entity
		Utente entity = Conversioni.da_UtenteDTO_a_Utente(dto);

		// 2.inserisco l entity attraverso il dao
		return dao.insert(entity);

	}

	public UtenteDTO cercaPerId(int id) {
		// 1. chiamo il dao
		Utente utente = dao.selectById(id);

		if (utente != null) {
			UtenteDTO dto = Conversioni.da_Utentea_UtenteDTO(utente);

			return dto;
		}
		return null;
	}

	public LinkedList<UtenteDTO> mostraUtenti() {
		List<Utente> lista_dao = dao.selectAll(); // lista degli utenti entity
		LinkedList<UtenteDTO> lista_dto = new LinkedList<>();

		for (Utente u : lista_dao) {
			lista_dto.add(Conversioni.da_Utentea_UtenteDTO(u));

		}
		System.out.println("lista service" + lista_dto);

		return lista_dto;

	}

	public UtenteDTO rimuoviutente(int idUtDTO) { // passo l id dell utente dto

		// cerco l utente di tipo entity nel DAO
		Utente utente = dao.selectById(idUtDTO);
		if (utente != null) { // se esiste lo elimino, lo converto e lo restituisco al controller come utente
								// DTO

			dao.delete(utente.getId());
			UtenteDTO utenteDTOeliminato = Conversioni.da_Utentea_UtenteDTO(utente);
			return utenteDTOeliminato;

		}

		return null;

	}

	
	public NomeCognomeDTO getNomeCgnome(int idUtDTO) {

		Utente utente = dao.selectById(idUtDTO);

		if (utente != null) {
			return new NomeCognomeDTO(utente.getNome(), utente.getCognome());
		}
		return null;
	}

	
	

	
	public ListaNomeCognomeDTO tuttiNomiCognomi() {
		List<Utente> lista_dao = dao.selectAll(); // lista degli utenti entity
		LinkedList<NomeCognomeDTO> lista_NCdto = new LinkedList<>();
		int contatore_utenti = 0;
		
		for (Utente u : lista_dao) { //cambia da utente entity a Nome Cognome dto
			NomeCognomeDTO nc_DTO = new NomeCognomeDTO(u.getNome(), u.getCognome());
			lista_NCdto.add(nc_DTO);
			contatore_utenti++;

		}
		ListaNomeCognomeDTO lncDTO = new ListaNomeCognomeDTO(lista_NCdto, contatore_utenti);  //lista Nomi Cognomi e contatore
		System.out.println("lista service" + lista_NCdto);

		return lncDTO;
	}

}
