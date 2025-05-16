package com.spring.progetto2.service;

import com.spring.progetto2.utility.Conversioni;

import java.util.ArrayList;
import java.util.List;

import com.spring.progetto2.dao.DAO_Prodotto;
import com.spring.progetto2.dto.ProdottoDTO;
import com.spring.progetto2.dto.ProdottoNoIdDTO;
import com.spring.progetto2.dto.ReportDTO;
import com.spring.progetto2.entity.Prodotto;

public class ProdottoService {

	private DAO_Prodotto dao = new DAO_Prodotto();

	public boolean CaricamentoProdotto(ProdottoDTO pDTO) {
		Prodotto entity = Conversioni.da_DTO_a_Entity(pDTO);
		return dao.insert(entity);
	}

	public ProdottoDTO cercaProdottoId(int id) {

		Prodotto prodotto = dao.selectById(id);

		if (prodotto != null) {
			ProdottoDTO dto = Conversioni.da_Entity_a_DTO(prodotto);

			return dto;
		}
		return null;
	}

	public ReportDTO repProdotti() {

		return Conversioni.generaReportDaProdotti(dao.selectAll());
	}

	public List<ProdottoNoIdDTO> cercaProdottiSenzaId() {
		List<ProdottoNoIdDTO> listaNoId = new ArrayList<>();
		for (Prodotto p : dao.selectAll()) {
			listaNoId.add(Conversioni.da_id_a_SenzaIdDTO(p));

		}
		return listaNoId;

	}

}
