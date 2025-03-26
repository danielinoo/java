package com.spring.progetto6.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.spring.progetto6.entity.impiegatoEntity;

public interface ImpiegatiDao extends JpaRepository<impiegatoEntity, Integer> {

	// eredita tutte le funzioni CRUD
	
	//query native
	
	//dato un salario ritorna una lista di impiegati con salario più alto
	@Query(nativeQuery = true, value = "select * from impiegato_entity where salario_mensile > :salario")
	public List<impiegatoEntity> getSalario(double salario);
	
	//tutti impiegati ordinati per cognome
	@Query(nativeQuery = true, value = "select * from impiegato_entity order by cognome")
	public List<impiegatoEntity> getByCognome();


}
