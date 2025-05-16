package com.spring.esameJava.dto;

import java.util.ArrayList;
import java.util.List;

public class venditoreDTO {
	
		private int id;
		
		private String nome,cognome,password,via,citta;
		
		
		private List<prodottoDTO> prodotti = new ArrayList<>();



		public venditoreDTO() {
			super();
		}



		public venditoreDTO(int id, String nome, String cognome, String password, String via, String citta) {
			super();
			this.id = id;
			this.nome = nome;
			this.cognome = cognome;
			this.password = password;
			this.via = via;
			this.citta = citta;
		}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}



		public String getCognome() {
			return cognome;
		}



		public void setCognome(String cognome) {
			this.cognome = cognome;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public String getVia() {
			return via;
		}



		public void setVia(String via) {
			this.via = via;
		}



		public String getCitta() {
			return citta;
		}



		public void setCitta(String citta) {
			this.citta = citta;
		}



		public List<prodottoDTO> getProdottiDTO() {
			return prodotti;
		}



		public void setProdotti(List<prodottoDTO> prodottiDTO) {
			this.prodotti = prodottiDTO;
		}
		
	
		public void aggiungiProdotto(prodottoDTO dto) {
			prodotti.add(dto);
		}
		
	}



