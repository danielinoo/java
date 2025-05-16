package com.spring.esameJava.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class venditore {
	
	@Id
	private int id;
	
	private String nome,cognome,password,via,citta;
	
	
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_venditore")
	private List<prodotto> prodotti = new ArrayList<>();



	public venditore() {
		super();
	}



	public venditore(int id, String nome, String cognome, String password, String via, String citta) {
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



	public List<prodotto> getProdotti() {
		return prodotti;
	}



	public void setProdotti(List<prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	

	public void aggiungiProdotto(prodotto p) {
		prodotti.add(p);
	}
	
}
