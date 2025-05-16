package com.spring.esameJava.service;



import com.spring.esameJava.dto.prodottoDTO;
import com.spring.esameJava.dto.venditoreDTO;
import com.spring.esameJava.dto.venditoreSPdto;

public interface venditoreService {
	public boolean inserisciVenditore(venditoreDTO dto);

	public venditoreDTO cerca(int id);

	public venditoreSPdto vediSoloVenditore(int id);

	public venditoreDTO modificaPassword(int id, String password);

	public boolean aggprodotto(int id ,prodottoDTO dto);

	public boolean modificaQuantita(int idVenditore, int idProdotto, int quantita );

}
