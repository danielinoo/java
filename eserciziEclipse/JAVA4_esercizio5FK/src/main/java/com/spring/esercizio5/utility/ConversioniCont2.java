package com.spring.esercizio5.utility;

import com.spring.esercizio5.dto.contattoDTO;
import com.spring.esercizio5.entity.contattoEntity;

public class ConversioniCont2 {
	public static contattoEntity da_DTO_a_Entity(contattoDTO dto) {
		return new contattoEntity(dto.getId(), dto.getNome(),dto.getCognome(),dto.getNumero());
	}

	public static contattoDTO da_Entity_a_DTO(contattoEntity entity) {
		return new contattoDTO(entity.getId(),entity.getNome(),entity.getCognome(),entity.getNumero());
	}

}
