package com.spring.progetto3.professore.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.progetto3.professore.entity.PROFESSORE;
@Repository
public class Professore_DAO implements DAOProfessore {

	private Map<Integer, PROFESSORE> mappa = new HashMap<>();

	
	
	
	public boolean insert(PROFESSORE PROFESSORE) {
		if (mappa.containsKey(PROFESSORE.getId()))
			return false;

		mappa.put(PROFESSORE.getId(), PROFESSORE);
		return true;

	}
	
	//mostra tutti
	public List<PROFESSORE> selectAll() {
		return new ArrayList<>(mappa.values());
	}
	
	//cerca per id
	public PROFESSORE selectById(Integer id) {
		return mappa.get(id);
	}

	// controllo se c è l id e lo cancella
	public boolean delete(Integer id) {
		PROFESSORE Prof = mappa.remove(id);
		return Prof != null;
	}

	
	
	//modifica un valore
	public PROFESSORE ModificaMateria(int id, String materia) {
		
		
		PROFESSORE prof = selectById(id);  //cerca il professore
		
		prof.setMateriaInsegnamento(materia);  //setta la nuova materia di insegnamento
		
		
		return prof;
	}
}
