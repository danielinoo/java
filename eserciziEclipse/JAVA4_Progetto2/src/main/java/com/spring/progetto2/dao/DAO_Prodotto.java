package com.spring.progetto2.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.progetto2.entity.Prodotto;


public class DAO_Prodotto {
	
	private Map<Integer, Prodotto> mappa = new HashMap<>();
	
	
	public boolean insert(Prodotto prodotto) {
		if(mappa.containsKey(prodotto.getId()))
			return false;
		
		mappa.put(prodotto.getId(), prodotto);
		return true;

	}
	public List<Prodotto> selectAll(){
		return new ArrayList<>(mappa.values());
	}

	public Prodotto selectById(Integer idProdotto) {
		return mappa.get(idProdotto);
	}
	
	//controllo se c è l id e lo cancella 
	public boolean delete(Integer idProdotto) {
		Prodotto prodotto= mappa.remove(idProdotto);
		return prodotto!=null;
	}
	
}
