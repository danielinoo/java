package com.spring.progetto3.studente.service;

import java.util.LinkedList;
import java.util.List;

import com.spring.progetto3.studente.dao.Studente_DAO;
import com.spring.progetto3.studente.dto.CognomeAnnoStudenteDTO;
import com.spring.progetto3.studente.dto.CognomeImmatricolazioneSTUDENTEdto;
import com.spring.progetto3.studente.dto.StudenteDTO;
import com.spring.progetto3.studente.entity.STUDENTE;
import com.spring.progetto3.utility.ConversioniStudente;

public class Studente_SERVICE {

	private Studente_DAO dao = new Studente_DAO();

	public boolean InserimentoStudente(StudenteDTO matricolaDTO) {
		STUDENTE entity = ConversioniStudente.da_DTO_a_Entity(matricolaDTO);
		return dao.insert(entity);
	}

	public StudenteDTO cercaMatricola(int matricolaDTO) {

		STUDENTE stu = dao.selectByMatricola(matricolaDTO);

		if (stu != null) {
			StudenteDTO dto = ConversioniStudente.da_Entity_a_DTO(stu);

			return dto;
		}
		return null;
	}

	public LinkedList<StudenteDTO> mostraStudenti() {
		List<STUDENTE> lista_dao = dao.selectAll(); // lista professori entity
		LinkedList<StudenteDTO> lista_dto = new LinkedList<>();

		for (STUDENTE s : lista_dao) {
			lista_dto.add(ConversioniStudente.da_Entity_a_DTO(s));

		}
		System.out.println("lista Studenti" + lista_dto);

		return lista_dto;

	}

	public StudenteDTO rimuoviStudente(int matricolaDTO) {
		STUDENTE stu = dao.selectByMatricola(matricolaDTO);
		if (stu != null) {

			dao.delete(stu.getMatricola());
			StudenteDTO studenteDTOeliminato = ConversioniStudente.da_Entity_a_DTO(stu);
			return studenteDTOeliminato;

		}

		return null;

	}

	public StudenteDTO modificaIndirizzo(int matricolaDTO, String nuovoIndirizzo) {

		STUDENTE stu = dao.selectByMatricola(matricolaDTO); // verifico se esiste

		if (stu != null) {
			stu = dao.ModificaIndirizzo(matricolaDTO, nuovoIndirizzo); // cambio materia e converto

			StudenteDTO stuDTO = ConversioniStudente.da_Entity_a_DTO(stu);

			return stuDTO;
		}

		return null;
	}

	public LinkedList<String> mostraNomiStudenti() {
		List<STUDENTE> lista_dao = dao.selectAll(); // lista professori entity
		LinkedList<String> lista_nomiDTO = new LinkedList<>();

		for (STUDENTE s : lista_dao) {
			lista_nomiDTO.add(s.getNome());

		}
		System.out.println("lista Studenti" + lista_nomiDTO);

		return lista_nomiDTO;

	}

	public CognomeAnnoStudenteDTO studenteGiovane() {
		List<STUDENTE> lista_dao = dao.selectAll(); // lista professori entity
		CognomeAnnoStudenteDTO gsDTO = new CognomeAnnoStudenteDTO(0, null); // imposto la data con numero alto per
																			// cominciare il ciclo

		for (STUDENTE s : lista_dao) {
			if (gsDTO.getAnnoNascita() < s.getAnnoNascita()) {
				gsDTO = ConversioniStudente.da_Entity_a_CognomeDataDTO(s);
			}
		}

		return gsDTO;

	}

	public CognomeImmatricolazioneSTUDENTEdto studentePiuIscritto() {
		List<STUDENTE> lista_dao = dao.selectAll(); // lista professori entity
		CognomeImmatricolazioneSTUDENTEdto cisDTO = new CognomeImmatricolazioneSTUDENTEdto(6000, null); // imposto la data con numero alto per
																			// cominciare il ciclo

		for (STUDENTE s : lista_dao) {
			if (cisDTO.getannoImmatricolazione()> s.getAnnoImmatricolazione()) {
				cisDTO = ConversioniStudente.da_Entity_a_CognomeImmDTO(s);
			}
		}

		return cisDTO;

	}

}
