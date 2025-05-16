package com.spring.progetto3.studente.dao;

import java.util.List;

import com.spring.progetto3.studente.entity.STUDENTE;

public interface StudenteDAO {

	public boolean insert(STUDENTE STUDENTE);

	public List<STUDENTE> selectAll();

	public STUDENTE selectByMatricola(Integer Matricola);

	public boolean delete(Integer matricola);

	public STUDENTE ModificaIndirizzo(int matricola, String indirizzo);

}
