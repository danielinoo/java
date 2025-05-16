package com.spring.esameJava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class prodotto {
	@Id
	private int id;

	private String descrizione;
	private int quantita;
	private double prezzo;
	private int sconto;
	private String categoria;

	public prodotto() {
		super();
	}

	public prodotto(int id, String descrizione, int quantita, double prezzo, int sconto, String categoria) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.sconto = sconto;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
