package com.spring.progetto5.utility;

import com.spring.progetto5.dto.ContattiProprietario;
import com.spring.progetto5.dto.ProprietarioAnnoDTO;

import com.spring.progetto5.entity.RubricaEntity;

public class ConversioniProprietario {

	public static ProprietarioAnnoDTO da_Entity_a_ProprioetarioAnno(RubricaEntity entity) {
		return new ProprietarioAnnoDTO(entity.getAnnoCreazione(), entity.getProprietario());
	}


	public static ContattiProprietario da_Entity_a_ContattattiProprietario(RubricaEntity entity) {
		return new ContattiProprietario(entity.getProprietario(), entity.getLista().size());
	}

}
