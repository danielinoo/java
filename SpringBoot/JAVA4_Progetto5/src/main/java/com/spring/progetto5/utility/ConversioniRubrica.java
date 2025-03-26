package com.spring.progetto5.utility;

import java.util.LinkedList;

import com.spring.progetto5.dto.ContattoDTO;
import com.spring.progetto5.dto.RubricaDTO;
import com.spring.progetto5.entity.ContattoEntity;
import com.spring.progetto5.entity.RubricaEntity;

public class ConversioniRubrica {

	public static RubricaEntity da_DTO_a_Entity(RubricaDTO dto) {
		
		//variabili d appoggio
		LinkedList<ContattoEntity>ContattiEntity =  new LinkedList<>();
		ContattoEntity Centity;
	
		//conversione contatti da dto a entity
			for (ContattoDTO CDTO : dto.getLista()) {
				Centity = ConversioniContatto.da_DTO_a_Entity(CDTO);
				ContattiEntity.add(Centity);
			}
		
		
		return new RubricaEntity(dto.getId(),ContattiEntity,dto.getAnnoCreazione(),dto.getProprietario());
	}

	public static RubricaDTO da_Entity_a_DTO(RubricaEntity entity) {
		
		//variabili d appoggio
		LinkedList<ContattoDTO>ContattiDTO =  new LinkedList<>();
		ContattoDTO CDTO;
	
		//conversione contatti da entity a dto
			for (ContattoEntity centity : entity.getLista()) {
				CDTO = ConversioniContatto.da_Entity_a_DTO(centity);
				ContattiDTO.add(CDTO);
			}
		
		
		return new RubricaDTO(entity.getId(), ContattiDTO, entity.getAnnoCreazione(),entity.getProprietario());
	
	
	}
	
}


	