package com.spring.esercizio5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class contattoEntity {
	
	@Id
	private int id;
	
	private String nome,cognome,numero;

	public contattoEntity() {
		super();
	}

	public contattoEntity(int id, String nome, String cognome, String numero) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
