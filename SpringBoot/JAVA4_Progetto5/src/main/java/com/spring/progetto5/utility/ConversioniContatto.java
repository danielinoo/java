package com.spring.progetto5.utility;

import java.sql.Date;

import com.spring.progetto5.dto.ContattoDTO;
import com.spring.progetto5.dto.NomeCognomeContattoDTO;
import com.spring.progetto5.entity.ContattoEntity;

public class ConversioniContatto {

	public static ContattoEntity da_DTO_a_Entity(ContattoDTO dto) {
		return new ContattoEntity(dto.getId(), dto.getNome(),dto.getCognome(),dto.getNumero(),dto.getGruppo_appartenenza(),(Date) dto.getDataNascita(),dto.isPreferito());
	}

	public static ContattoDTO da_Entity_a_DTO(ContattoEntity entity) {
		return new ContattoDTO(entity.getId(),entity.getNome(),entity.getCognome(),entity.getNumero(),entity.getGruppo_appartenenza(),entity.getDataNascita(),entity.isPreferito());
	}
	
	public static NomeCognomeContattoDTO da_Entity_a_NomeCognomeDTO(ContattoEntity entity) {
		return new NomeCognomeContattoDTO(entity.getNome(),entity.getCognome());
	}
}


	