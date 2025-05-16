package com.spring.esercizio4Studenti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.esercizio4Studenti.entity.Studente;


//JpaRepository<Studente, Int> --> collegamento alla tabella (studente) e il tipo della primary key (matricola) (in questo caso integer)
public interface daoStudente extends JpaRepository<Studente, Integer>{
	
	//eredita tutte le funzioni CRUD
	
	
	//query native
	
	//:annoimmatr --> variabile
	@Query(nativeQuery = true, value = "select * from studente where anno_imm > :annoimmatr")
	public List<Studente> getGiovani(int annoimmatr);
	
	

}
