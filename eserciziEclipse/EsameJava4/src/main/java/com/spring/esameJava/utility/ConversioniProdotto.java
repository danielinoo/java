package com.spring.esameJava.utility;

import com.spring.esameJava.dto.prodottoDTO;
import com.spring.esameJava.entity.prodotto;


public class ConversioniProdotto {

	public static prodotto da_DTO_a_Entity(prodottoDTO dto) {
			return new prodotto(dto.getId(), dto.getDescrizione(),dto.getQuantita(),dto.getPrezzo(),dto.getSconto(),dto.getCategoria() );
		}

		public static prodottoDTO da_Entity_a_DTO(prodotto entity) {
			return new prodottoDTO(entity.getId(),entity.getDescrizione(),entity.getQuantita(),entity.getPrezzo(),entity.getSconto(),entity.getCategoria());
		}

		

	}


