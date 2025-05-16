package com.spring.esameJava.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.esameJava.dao.DaoVenditori;
import com.spring.esameJava.dto.prodottoDTO;
import com.spring.esameJava.dto.venditoreDTO;
import com.spring.esameJava.dto.venditoreSPdto;
import com.spring.esameJava.entity.prodotto;
import com.spring.esameJava.entity.venditore;
import com.spring.esameJava.utility.ConversioniProdotto;
import com.spring.esameJava.utility.ConversioniVenditori;

@Service
@Transactional
public class service implements venditoreService {

	@Autowired
	DaoVenditori dao;

	@Override
	public boolean inserisciVenditore(venditoreDTO dto) {


		Optional<venditore> opt = dao.findById(dto.getId());

		if (opt.isPresent()) {
			throw new RuntimeException("il venditore è già presente");
		} else {
			

			venditore entity = ConversioniVenditori.da_Dto_A_Entity(dto);
			dao.save(entity);
			return true;
		}

	}

	@Override
	public venditoreDTO cerca(int id) {
		
		Optional<venditore> opt = dao.findById(id);

		if (opt.isPresent()) {
			

			venditore entity = opt.get();
			venditoreDTO dto = ConversioniVenditori.da_Entity_A_Dto(entity);
			return dto;
		} else {
			throw new RuntimeException("l'id inserito non esiste");
		}

	}

	@Override
	public venditoreDTO modificaPassword(int id, String nuovaPassword) {
		
		Optional<venditore> opt = dao.findById(id);

		if (opt.isPresent()) {

			venditore entity = opt.get();
			
			
			entity.setPassword(nuovaPassword);
			System.out.println(entity.getPassword());
			venditoreDTO dto = ConversioniVenditori.da_Entity_A_Dto(entity);
			System.out.println(dto.getPassword());
			return dto;
		} else {
			throw new RuntimeException("l'id inserito non esiste");
		}
	}

	@Override
	public boolean aggprodotto(int id, prodottoDTO dto) {
		Optional<venditore> opt = dao.findById(id);

		if (opt.isPresent()) {

			venditore entity = opt.get();

			entity.aggiungiProdotto(ConversioniProdotto.da_DTO_a_Entity(dto));

			return true;
		} else {
			throw new RuntimeException("l'id inserito non esiste");
		}

	}

	@Override
	public boolean modificaQuantita(int idVenditore, int idProdotto, int quantita) {
		
		Optional<venditore> opt = dao.findById(idVenditore);

		if (opt.isPresent()) {

			venditore entity = opt.get();
			
			
			for (prodotto p : entity.getProdotti()) {
				if (p.getId() == idProdotto) {
					p.setQuantita(quantita);
				}
			}

			return true;
		} else {
			throw new RuntimeException("l'id inserito non esiste");
		}
	}

	@Override
	public venditoreSPdto vediSoloVenditore(int id) {
		Optional<venditore> opt = dao.findById(id);

		if (opt.isPresent()) {
			
			venditore entity = opt.get();
			venditoreSPdto senzaProdotti = ConversioniVenditori.da_entity_a_VenditoreSenzaProdotti(entity);
			return senzaProdotti;
		} else {
			throw new RuntimeException("l'id inserito non esiste");
		}

	

	}

}
