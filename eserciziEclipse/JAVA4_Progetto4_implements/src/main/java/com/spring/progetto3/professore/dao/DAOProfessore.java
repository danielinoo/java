package com.spring.progetto3.professore.dao;

import java.util.List;

import com.spring.progetto3.professore.entity.PROFESSORE;

public interface DAOProfessore {

	public boolean insert(PROFESSORE PROFESSORE);

	public List<PROFESSORE> selectAll();

	public PROFESSORE selectById(Integer id);

	public boolean delete(Integer id);

	public PROFESSORE ModificaMateria(int id, String materia);

}
