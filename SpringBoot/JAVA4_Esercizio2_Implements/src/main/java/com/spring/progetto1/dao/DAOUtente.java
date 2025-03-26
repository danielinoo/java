package com.spring.progetto1.dao;

import java.util.List;

import com.spring.progetto1.entity.Utente;

public interface DAOUtente {

	public boolean insert(Utente utente);

	public List<Utente> selectAll();
	

	public Utente selectById(Integer idUtente);
		
		public boolean delete(Integer idUtente);
	
}
