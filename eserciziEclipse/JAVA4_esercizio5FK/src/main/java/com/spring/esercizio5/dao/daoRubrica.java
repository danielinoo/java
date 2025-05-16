package com.spring.esercizio5.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.esercizio5.entity.rubricaEntity;


public interface daoRubrica extends JpaRepository<rubricaEntity, Integer> {
	

}
