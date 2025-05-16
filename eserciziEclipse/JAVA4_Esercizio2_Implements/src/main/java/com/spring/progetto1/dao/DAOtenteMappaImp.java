package com.spring.progetto1.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.progetto1.entity.Utente;


@Repository
public class DAOtenteMappaImp implements DAOUtente {

	//crea una mappa in cui ogni chiave è un numero intero (Integer)
	//e ogni valore è un oggetto di tipo Utente
	private Map<Integer, Utente> mappa = new HashMap<>();

	public boolean insert(Utente utente) {
		if(mappa.containsKey(utente.getId()))
			return false;
		
		mappa.put(utente.getId(), utente);
		return true;


	}
	public List<Utente> selectAll(){
		return new ArrayList<>(mappa.values());
	}

	public Utente selectById(Integer idUtente) {
		Utente utente =mappa.get(idUtente);
		
		if (utente != null) {
		return utente;
	}
		return null;
	}
	
	//controllo se c è l id e lo cancella 
	public boolean delete(Integer idUtente) {
		Utente utente = mappa.remove(idUtente);
		return utente!=null;
	}
	
	

}