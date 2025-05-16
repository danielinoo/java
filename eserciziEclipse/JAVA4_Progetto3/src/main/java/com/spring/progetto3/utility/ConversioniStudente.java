package com.spring.progetto3.utility;

import com.spring.progetto3.studente.dto.CognomeAnnoStudenteDTO;
import com.spring.progetto3.studente.dto.CognomeImmatricolazioneSTUDENTEdto;
import com.spring.progetto3.studente.dto.StudenteDTO;
import com.spring.progetto3.studente.entity.STUDENTE;

public class ConversioniStudente {

	


		public static STUDENTE da_DTO_a_Entity(StudenteDTO dto) {
			return new STUDENTE( dto.getMatricola(),  dto.getNome(), dto.getCognome(), dto.getIndirizzo(), dto.getAnnoNascita(),  dto.getAnnoImmatricolazione());
		}

		public static StudenteDTO  da_Entity_a_DTO(STUDENTE entity) {
			return new StudenteDTO(entity.getMatricola(), entity.getNome(), entity.getCognome(),entity.getIndirizzo(), entity.getAnnoNascita(), entity.getAnnoImmatricolazione());
		}
		
		
		public static  CognomeAnnoStudenteDTO da_Entity_a_CognomeDataDTO(STUDENTE entity) {
			return new CognomeAnnoStudenteDTO(entity.getAnnoNascita(), entity.getCognome());
		}
		
		public static  CognomeImmatricolazioneSTUDENTEdto	da_Entity_a_CognomeImmDTO(STUDENTE entity) {
			return new CognomeImmatricolazioneSTUDENTEdto(entity.getAnnoImmatricolazione(), entity.getCognome());
		}
		
		
	}


		

