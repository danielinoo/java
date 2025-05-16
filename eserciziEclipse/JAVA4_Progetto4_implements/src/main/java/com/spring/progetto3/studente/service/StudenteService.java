package com.spring.progetto3.studente.service;

import java.util.LinkedList;

import com.spring.progetto3.studente.dto.CognomeAnnoStudenteDTO;
import com.spring.progetto3.studente.dto.CognomeImmatricolazioneSTUDENTEdto;
import com.spring.progetto3.studente.dto.StudenteDTO;

public interface StudenteService {

	public boolean InserimentoStudente(StudenteDTO matricolaDTO);

	public StudenteDTO cercaMatricola(int matricolaDTO);

	public LinkedList<StudenteDTO> mostraStudenti();

	public StudenteDTO rimuoviStudente(int matricolaDTO);

	public StudenteDTO modificaIndirizzo(int matricolaDTO, String nuovoIndirizzo);

	public LinkedList<String> mostraNomiStudenti();
	
	public CognomeAnnoStudenteDTO studenteGiovane();

	public CognomeImmatricolazioneSTUDENTEdto studentePiuIscritto();
}
