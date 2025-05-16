package com.spring.progetto3.utility;



import com.spring.progetto3.professore.dto.ProfessoreDTO;
import com.spring.progetto3.professore.entity.PROFESSORE;

public class ConversioniProfessore {

	public static PROFESSORE da_DTO_a_Entity(ProfessoreDTO dto) {
		return new PROFESSORE(dto.getId(), dto.getNome(), dto.getCognome(), dto.getMateriaInsegnamento());
	}

	public static ProfessoreDTO da_Entity_a_DTO(PROFESSORE entity) {
		return new ProfessoreDTO(entity.getId(), entity.getNome(), entity.getCognome(), entity.getMateriaInsegnamento());
	}
	
}


	