package com.spring.progetto6.utility;



import com.spring.progetto6.dto.NomeCognomeDTO;
import com.spring.progetto6.dto.impiegatoDTO;
import com.spring.progetto6.entity.impiegatoEntity;

public class ConversioniImp {
	
	
	
	public static impiegatoEntity da_DTO_a_Entity(impiegatoDTO dto) {
		return new impiegatoEntity(dto.getMatricola(), dto.getNome(),dto.getCognome(),dto.getSalarioMensile());
		
	}
	
	public static impiegatoDTO da_Entity_a_DTO(impiegatoEntity entity) {
		return new impiegatoDTO(entity.getMatricola(),entity.getNome(),entity.getCognome(),entity.getSalarioMensile());
	}
	
	public static NomeCognomeDTO da_Entity_a_NomeCognomeDTO(impiegatoEntity entity) {
		return new NomeCognomeDTO(entity.getNome(),entity.getCognome());
	}

	
}
