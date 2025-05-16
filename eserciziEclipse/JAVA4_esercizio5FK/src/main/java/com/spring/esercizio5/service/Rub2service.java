package com.spring.esercizio5.service;

import java.util.List;

import com.spring.esercizio5.dto.contattoDTO;
import com.spring.esercizio5.dto.rubricaDTO;

public interface Rub2service {

	// crea rubrica
	public boolean creaRubrica(rubricaDTO dto);

	// cerca
	public rubricaDTO cerca(int id);

	// visualizzatutte le rubriche
	public List<rubricaDTO> mostraRubriche();

	// elimina rubrica
	public rubricaDTO rimuoviRubrica(int idrDTO);

	// aggiungi contatto
	public boolean aggContatto(int id, contattoDTO dto);

	// visualizza un contatto per id
	public contattoDTO cercaContatto(int id, int IDcontatto);

	// elimina contatto esistente
	public contattoDTO eliminaContatto(int id, int IDcontatto);

	// visualizza tutti i contatti
	public List<contattoDTO> VisualizzaContatti(int id);

	// modifica ANNOCreazione
	public rubricaDTO modificaAnnoCreazione(int idRubrica, int NuovoAnno);

	// ricerca numero di contatti di un dato gruppo
	public int NumeroContattiGruppo(int id, String gruppo);

	// Modifica Contatto esistente (tutti campi tranne id)
	public contattoDTO modificaContatto(int id, contattoDTO nuovoDTO);

}
