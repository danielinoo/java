package com.spring.progetto3.professore.service;

import java.util.LinkedList;

import com.spring.progetto3.professore.dto.ProfessoreDTO;

public interface ProfService {

	public boolean InserimentoProf(ProfessoreDTO pDTO);

	public ProfessoreDTO cercaProfId(int id);

	public LinkedList<ProfessoreDTO> mostraProfessori();

	public ProfessoreDTO rimuoviProf(int idpDTO);

	public ProfessoreDTO modificaMateria(int idUtDTO, String nuovaMateria);
}
