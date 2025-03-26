package com.spring.progetto5.service;

import java.util.LinkedList;
import java.util.List;

import com.spring.progetto5.dto.ContattiProprietario;
import com.spring.progetto5.dto.ContattoDTO;
import com.spring.progetto5.dto.NomeCognomeContattoDTO;
import com.spring.progetto5.dto.ProprietariNumero;
import com.spring.progetto5.dto.ProprietarioAnnoDTO;
import com.spring.progetto5.dto.RubricaDTO;

public interface serviceRubricaContatti {

	// inserisci
	public boolean InserisciRubrica(RubricaDTO dto);
	
	// cerca per id
	public RubricaDTO cercaRubricaId(int id);
	
	// visualizzatutte le rubriche
	public LinkedList<RubricaDTO> mostraRubriche();
	
	// elimina rubrica
	public RubricaDTO rimuoviRubrica(int idrDTO);

	// visualizza solo proprietario e anno
	public ProprietarioAnnoDTO VisualizzaPA(int id);
	
	// modifica ANNOCreazione
	public RubricaDTO modificaAnnoCreazione(int idRubrica, int NuovoAnno); 
	
	// tutti i nomi dei proprietari e il loro numero totale
	public ProprietariNumero TuttiProprietari();
		
	// visualizza proprietario e anno creazione piu vecchia
	public ProprietarioAnnoDTO VisualizzaAnnoProprietario();
	
	//Visualizza tutti annoCreazione in ordine crescente
	public List<Integer> AnniCreazione();
	
	//visualizza nome del proprietario e il numero contatti di una rubrica
	public ContattiProprietario ContProp(int idRubrica);
	
	
	//inserisci nuovo Contatto
	public boolean InseriscContatto (int id, ContattoDTO dto);
	
	//visualizza un cattatto per id
	public ContattoDTO cercaContatto(int id, int IDcontatto);
	
	// Modifica Contatto esistente (tutti campi tranne id)
	public ContattoDTO modificaContatto(int id, ContattoDTO nuovoDTO);
	
	//elimina contatto esistente
	public ContattoDTO   eliminaContatto(int id, int IDcontatto);
	
	//visualizza tutti i contatti
	public LinkedList<ContattoDTO> VisualizzaContatti (int id);
	
	//visualizza numero  di contatti
	public int VisualizzaNUmeroContatti (int id);
	
	//cerca numero
	public ContattoDTO cercaNumero(int id, String num);
	
	//ricerca nome cognome dato un gruppo
	public LinkedList<NomeCognomeContattoDTO> ListaNomeCognome(int id, String gruppo);
	

	//ricerca numero di contatti di un dato gruppo
	public int NumeroContattiGruppo(int id, String gruppo);
	
	//cancella gruppo (tutti i contatti appartenenti)
	public LinkedList<ContattoDTO> ListaContattiEliminati(int id, String gruppo);
	
	//modifica contatto da non preferito a preferito
	public ContattoDTO modificaPreferito(int id, int IDcontatto);
	
	//lista preferiti
	public LinkedList<ContattoDTO> ListaPreferiti(int id);
}
