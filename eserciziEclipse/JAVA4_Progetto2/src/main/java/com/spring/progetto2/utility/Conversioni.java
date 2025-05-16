package com.spring.progetto2.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.spring.progetto2.dto.ProdottoDTO;
import com.spring.progetto2.dto.ProdottoNoIdDTO;
import com.spring.progetto2.dto.ReportDTO;
import com.spring.progetto2.entity.Prodotto;

public class Conversioni {

	public static Prodotto da_DTO_a_Entity(ProdottoDTO dto) {
		return new Prodotto(dto.getId(), dto.getMarca(), dto.getModello(), dto.getDescrizione(),
				dto.getPrezzo_consigliato(), dto.getPrezzo_massimo(), dto.getQuantita(), dto.getCategoria());
	}

	public static ProdottoDTO da_Entity_a_DTO(Prodotto entity) {
		return new ProdottoDTO(entity.getId(), entity.getMarca(), entity.getModello(), entity.getDescrizione(),
				entity.getPrezzo_consigliato(), entity.getPrezzo_massimo(), entity.getQuantita(),
				entity.getCategoria());

	}

	public static ProdottoNoIdDTO da_id_a_SenzaIdDTO (Prodotto entity) {
		return new ProdottoNoIdDTO( entity.getMarca(), entity.getModello(), entity.getDescrizione(),
				entity.getPrezzo_consigliato(), entity.getPrezzo_massimo(), entity.getQuantita(),
				entity.getCategoria());
	}
	
	
	
	
	public static ReportDTO generaReportDaProdotti(Collection<Prodotto> prodotti) {
		double  sommaPrezzi = 0;
		
		List<String> descrizioniDTO = new ArrayList<>();
		int pezzi_totDTO = 0;
		int numero_prodotti_non_disponibiliDTO = 0;
		double media_prezziDTO = 0;
		List<String> elenco_prodotti_non_disponibiliDTO = new ArrayList<>();

		
		for (Prodotto p : prodotti) {
			descrizioniDTO.add(p.getDescrizione()); //descrizioni
			pezzi_totDTO = pezzi_totDTO + p.getQuantita(); //pezzi totali
			
			if(p.getQuantita() == 0) {
				numero_prodotti_non_disponibiliDTO ++; //numero prodotti non disponibili
				elenco_prodotti_non_disponibiliDTO.add(p.getModello());
				
			}
			sommaPrezzi =sommaPrezzi + p.getPrezzo_consigliato(); //media dei prezzi consigliati
			
		}
		
		media_prezziDTO = sommaPrezzi / pezzi_totDTO;  //media
		
		return new ReportDTO(descrizioniDTO, pezzi_totDTO, numero_prodotti_non_disponibiliDTO, media_prezziDTO, elenco_prodotti_non_disponibiliDTO);
	}
	}
