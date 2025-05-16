package com.spring.progetto3.professore.service;


import com.spring.progetto3.professore.dao.Professore_DAO;
import com.spring.progetto3.professore.dto.ProfessoreDTO;
import com.spring.progetto3.professore.entity.PROFESSORE;
import com.spring.progetto3.utility.ConversioniProfessore;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfessoreSERVICEImp implements ProfService {

	@Autowired
	private Professore_DAO dao;

	public boolean InserimentoProf(ProfessoreDTO pDTO) {
		PROFESSORE entity = ConversioniProfessore.da_DTO_a_Entity(pDTO);
		return dao.insert(entity);
	}

	public ProfessoreDTO cercaProfId(int id) {

		PROFESSORE prof = dao.selectById(id);

		if (prof != null) {
			ProfessoreDTO dto = ConversioniProfessore.da_Entity_a_DTO(prof);

			return dto;
		}
		return null;
	}

	public LinkedList<ProfessoreDTO> mostraProfessori() {
		List<PROFESSORE> lista_dao = dao.selectAll(); // lista professori entity
		LinkedList<ProfessoreDTO> lista_dto = new LinkedList<>();

		for (PROFESSORE u : lista_dao) {
			lista_dto.add(ConversioniProfessore.da_Entity_a_DTO(u));

		}
		System.out.println("lista Professori" + lista_dto);

		return lista_dto;

	}

	public ProfessoreDTO rimuoviProf(int idpDTO) {
		PROFESSORE prof = dao.selectById(idpDTO);
		if (prof != null) {

			dao.delete(prof.getId());
			ProfessoreDTO profDTOeliminato = ConversioniProfessore.da_Entity_a_DTO(prof);
			return profDTOeliminato;

		}

		return null;

	}
	
	
	public ProfessoreDTO modificaMateria(int idUtDTO, String nuovaMateria) {

		 PROFESSORE prof = dao.selectById(idUtDTO);   //verifico se esiste

		if (prof != null) {
			prof = dao.ModificaMateria(idUtDTO, nuovaMateria);  //cambio materia e converto
			
			ProfessoreDTO profDTO = ConversioniProfessore.da_Entity_a_DTO(prof);
			
			return profDTO;
		}
		
		return null;
	}


}
