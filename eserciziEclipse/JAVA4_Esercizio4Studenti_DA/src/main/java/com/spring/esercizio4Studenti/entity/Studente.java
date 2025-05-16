package com.spring.esercizio4Studenti.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


//in application.properties (dentro src/main/resurces

@Entity
public class Studente {
	
	@Id //sempre jakarta
	private int matricola;
	
	private String nome,cognome;
	private int annoImm;
	public Studente() {
		super();
	}
	public Studente(int matricola, String nome, String cognome, int annoImm) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.annoImm = annoImm;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
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
	public int getAnnoImm() {
		return annoImm;
	}
	public void setAnnoImm(int annoImm) {
		this.annoImm = annoImm;
	}
	
	
	

}
