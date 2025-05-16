package com.spring.progetto3.studente.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.progetto3.studente.entity.STUDENTE;


@Repository
public class Studente_DAOImp implements StudenteDAO {

	private Map<Integer, STUDENTE> mappa = new HashMap<>();

	// inserisci
	public boolean insert(STUDENTE STUDENTE) {
		if (mappa.containsKey(STUDENTE.getMatricola()))
			return false;

		mappa.put(STUDENTE.getMatricola(), STUDENTE);
		return true;

	}

	// mostra tutti
	public List<STUDENTE> selectAll() {
		return new ArrayList<>(mappa.values());
	}

	// cerca per id
	public STUDENTE selectByMatricola(Integer Matricola) {
		return mappa.get(Matricola);
	}

	// controllo se c è l id e lo cancella
	public boolean delete(Integer matricola) {
		STUDENTE Studente = mappa.remove(matricola);
		return Studente != null;
	}

	// modifica un valore
	public STUDENTE ModificaIndirizzo(int matricola, String indirizzo) {

		STUDENTE Studente = selectByMatricola(matricola); // cerca il STUDENTE

		Studente.setIndirizzo(indirizzo); // setta la nuova materia di insegnamento

		return Studente;
	}
	
}
