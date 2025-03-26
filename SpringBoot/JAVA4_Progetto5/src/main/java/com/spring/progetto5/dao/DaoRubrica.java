package com.spring.progetto5.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.progetto5.entity.RubricaEntity;

@Repository
public interface DaoRubrica {
	
	public boolean insert(RubricaEntity r);

	public List<RubricaEntity> visualizzaRubriche();

	public RubricaEntity cercaId(Integer id);

	public boolean elimina(Integer id);

	public boolean update(RubricaEntity rubrica);

}
