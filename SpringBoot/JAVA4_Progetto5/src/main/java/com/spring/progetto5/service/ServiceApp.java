package com.spring.progetto5.service;

import java.sql.Date;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.progetto5.dao.DaoRubrica;
import com.spring.progetto5.dto.ContattiProprietario;
import com.spring.progetto5.dto.ContattoDTO;
import com.spring.progetto5.dto.NomeCognomeContattoDTO;
import com.spring.progetto5.dto.ProprietariNumero;
import com.spring.progetto5.dto.ProprietarioAnnoDTO;
import com.spring.progetto5.dto.RubricaDTO;
import com.spring.progetto5.entity.ContattoEntity;
import com.spring.progetto5.entity.RubricaEntity;
import com.spring.progetto5.utility.ConversioniContatto;
import com.spring.progetto5.utility.ConversioniProprietario;
import com.spring.progetto5.utility.ConversioniRubrica;

@Service
public class ServiceApp implements serviceRubricaContatti {

	@Autowired
	private DaoRubrica dao;

	// inserisci
	public boolean InserisciRubrica(RubricaDTO dto) {

		RubricaEntity rubrica = ConversioniRubrica.da_DTO_a_Entity(dto);

		return dao.insert(rubrica);

	}

	// cerca per id
	public RubricaDTO cercaRubricaId(int id) {

		RubricaEntity rubrica = dao.cercaId(id);

		if (rubrica != null) {
			RubricaDTO dto = ConversioniRubrica.da_Entity_a_DTO(rubrica);

			return dto;
		}
		return null;
	}

	// visualizzatutte le rubriche
	public LinkedList<RubricaDTO> mostraRubriche() {
		List<RubricaEntity> lista_dao = dao.visualizzaRubriche(); // lista entity
		LinkedList<RubricaDTO> lista_dto = new LinkedList<>();

		for (RubricaEntity u : lista_dao) {
			lista_dto.add(ConversioniRubrica.da_Entity_a_DTO(u));

		}
		System.out.println("lista rubriche" + lista_dto);

		return lista_dto;

	}

	// elimina rubrica
	public RubricaDTO rimuoviRubrica(int idrDTO) {
		RubricaEntity r = dao.cercaId(idrDTO);
		if (r != null) {

			dao.elimina(r.getId());
			RubricaDTO DTOeliminato = ConversioniRubrica.da_Entity_a_DTO(r);
			return DTOeliminato;

		}

		return null;

	}

	// visualizza solo proprietario e anno
	public ProprietarioAnnoDTO VisualizzaPA(int id) {
		RubricaEntity rubrica = dao.cercaId(id);

		return ConversioniProprietario.da_Entity_a_ProprioetarioAnno(rubrica);

	}

	// modifica Proprietario
	public RubricaDTO modificaProprietario(int idRubrica, String nuovoProprietario) {
		RubricaEntity rubrica = dao.cercaId(idRubrica);
		rubrica.setProprietario(nuovoProprietario);
		dao.update(rubrica);
		return ConversioniRubrica.da_Entity_a_DTO(rubrica);
	}

	// modifica ANNOCreazione
	public RubricaDTO modificaAnnoCreazione(int idRubrica, int NuovoAnno) {
		RubricaEntity rubrica = dao.cercaId(idRubrica);
		rubrica.setAnnoCreazione(NuovoAnno);
		dao.update(rubrica);
		return ConversioniRubrica.da_Entity_a_DTO(rubrica);
	}

	// tutti i nomi dei proprietari e il loro numero totale
	public ProprietariNumero TuttiProprietari() {
		LinkedList<String> proprietari = new LinkedList<>();

		for (RubricaEntity r : dao.visualizzaRubriche()) {
			proprietari.add(r.getProprietario());
		}
		int n = proprietari.size();

		return new ProprietariNumero(proprietari, n);
	}

	// visualizza proprietario e anno creazione piu vecchia
	public ProprietarioAnnoDTO VisualizzaAnnoProprietario() {

		ProprietarioAnnoDTO p = new ProprietarioAnnoDTO(5000, null);

		for (RubricaEntity r : dao.visualizzaRubriche()) {
			if (r.getAnnoCreazione() < p.getAnnoCreazione()) {

				p = ConversioniProprietario.da_Entity_a_ProprioetarioAnno(r);
			}
		}
		return p;
	}

	// Visualizza tutti annoCreazione in ordine crescente
	public List<Integer> AnniCreazione() {
		LinkedList<RubricaDTO> listaRubricheDTO = mostraRubriche();

		// lista con tutti gli anni creazione
		List<Integer> lista = new LinkedList<>();
		for (RubricaDTO r : listaRubricheDTO) {
			lista.add(r.getAnnoCreazione());
		}
		Collections.sort(lista);
		return lista;
	}

	// visualizza nome del proprietario e il numero contatti di una rubrica
	public ContattiProprietario ContProp(int idRubrica) {
		RubricaEntity entity = dao.cercaId(idRubrica);

		return ConversioniProprietario.da_Entity_a_ContattattiProprietario(entity);
	}

	// ----------------------------------------------------------

	//se il contatto esiste ritorna un dto sennò errore
	public static ContattoDTO ControlloIDContatto(int id, LinkedList<ContattoEntity> lista) {
		for (ContattoEntity c : lista) {
			if (c.getId() == id) {
				return ConversioniContatto.da_Entity_a_DTO(c);
			}
		}
		throw new RuntimeException("l' id del contatto è sbagliato");
	}

	// inserisci nuovo Contatto
	public boolean InseriscContatto(int id, ContattoDTO dto) {
		RubricaEntity r = dao.cercaId(id);
		ContattoEntity contattoEntity = ConversioniContatto.da_DTO_a_Entity(dto);
		if (r.getLista().contains(contattoEntity)) {
			return false;
		} else {
			r.getLista().add(contattoEntity);
			return true;
		}
	}

	// visualizza un contatto per id
	public ContattoDTO cercaContatto(int id, int IDcontatto) {
		RubricaEntity r = dao.cercaId(id);

		// metodo che controlla se esiste l utente
		ContattoDTO contatto = ControlloIDContatto(IDcontatto, r.getLista());

		return contatto;
	}

	// Modifica Contatto esistente (tutti campi tranne id)
	public ContattoDTO modificaContatto(int id, ContattoDTO nuovoDTO) {
		RubricaEntity r = dao.cercaId(id);
		for (ContattoEntity c : r.getLista()) {
			if (c.getId() == nuovoDTO.getId()) {

				c.setNome(nuovoDTO.getNome());
				c.setCognome(nuovoDTO.getCognome());
				c.setNumero(nuovoDTO.getNumero());
				c.setDataNascita((Date) nuovoDTO.getDataNascita());
				c.setGruppo_appartenenza(nuovoDTO.getGruppo_appartenenza());
				c.setPreferito(nuovoDTO.isPreferito());

				return ConversioniContatto.da_Entity_a_DTO(c);
			}

		}
		throw new RuntimeException("l' id del contatto è sbagliato");
	}

	// elimina contatto esistente
	public ContattoDTO eliminaContatto(int id, int IDcontatto) {
		RubricaEntity r = dao.cercaId(id);

		ContattoDTO contattoEliminato = ControlloIDContatto(IDcontatto, r.getLista());
		dao.elimina(contattoEliminato.getId());
		return contattoEliminato;
	}

	// visualizza tutti i contatti
	public LinkedList<ContattoDTO> VisualizzaContatti(int id) {
		RubricaDTO rubrica = cercaRubricaId(id);
		return rubrica.getLista();
	}

	// visualizza numero di contatti
	public int VisualizzaNUmeroContatti(int id) {
		RubricaDTO rubrica = cercaRubricaId(id);
		return rubrica.getLista().size();
	}

	// cerca numero
	public ContattoDTO cercaNumero(int id, String num) {
		RubricaEntity r = dao.cercaId(id);

		for (ContattoEntity c : r.getLista()) {
			if (c.getNumero().equals(num)) {
				return ConversioniContatto.da_Entity_a_DTO(c);
			}

		}
		throw new RuntimeException("il numero inserito non esiste");

	}

	// ricerca nome cognome dato un gruppo
	public LinkedList<NomeCognomeContattoDTO> ListaNomeCognome(int id, String gruppo) {

		RubricaEntity r = dao.cercaId(id);
		LinkedList<NomeCognomeContattoDTO> listaNomeCognomeDTO = new LinkedList<>();

		for (ContattoEntity c : r.getLista()) {
			if (c.getGruppo_appartenenza().equals(gruppo)) {
				NomeCognomeContattoDTO NomeCognome = ConversioniContatto.da_Entity_a_NomeCognomeDTO(c);
				listaNomeCognomeDTO.add(NomeCognome);

			}

		}
		if (listaNomeCognomeDTO.size() > 0) {
			return listaNomeCognomeDTO;
		} else {
			throw new RuntimeException("il gruppo inserito non esiste");
		}

	}

	// ricerca numero di contatti di un dato gruppo
	public int NumeroContattiGruppo(int id, String gruppo) {
		LinkedList<NomeCognomeContattoDTO> lista = ListaNomeCognome(id, gruppo);
		return lista.size();
	}

	// cancella gruppo (tutti i contatti appartenenti)
	public LinkedList<ContattoDTO> ListaContattiEliminati(int id, String gruppo) {

		RubricaEntity r = dao.cercaId(id);
		LinkedList<ContattoDTO> listaEliminatiDTO = new LinkedList<>();

		for (ContattoEntity c : r.getLista()) {
			if (c.getGruppo_appartenenza().equals(gruppo)) {
				r.getLista().remove(c);
				listaEliminatiDTO.add(ConversioniContatto.da_Entity_a_DTO(c));

			}

		}
		//se la lista degli utenti è vuota significa che il gruppo inserito non esiste
		if (listaEliminatiDTO.size() > 0) {
			return listaEliminatiDTO;
		} else {
			throw new RuntimeException("il gruppo inserito non esiste");
		}
	}

	// modifica contatto da non preferito a preferito
	public ContattoDTO modificaPreferito(int id, int IDcontatto) {
		RubricaEntity r = dao.cercaId(id);
		
		ContattoDTO c = ControlloIDContatto(IDcontatto, r.getLista());
		c.setPreferito(true);
		return c;
	}

	// lista preferiti
	public LinkedList<ContattoDTO> ListaPreferiti(int id) {
		LinkedList<ContattoDTO> lista = VisualizzaContatti(id);
		LinkedList<ContattoDTO> listaPreferitiDTO = new LinkedList<>();

		for (ContattoDTO c : lista) {
			if (c.isPreferito()) {
				listaPreferitiDTO.add(c);
			}

		}
		return listaPreferitiDTO;
	}

}
