package com.spring.esercizio4Studenti.service;


import java.util.LinkedList;
import java.util.List;

import com.spring.esercizio4Studenti.dto.StudenteDTO;


public interface serviceStudenti {
	
	public boolean immatricola(StudenteDTO dto);
		
	public StudenteDTO cerca(int matricola);
	
	public LinkedList<StudenteDTO> visualizza();
	
	public StudenteDTO elimina(int matricola);
	
	public List<StudenteDTO> getGiovani(int annoimmatr);
}
