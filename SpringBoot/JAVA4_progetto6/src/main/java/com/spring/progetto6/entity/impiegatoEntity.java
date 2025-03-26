package com.spring.progetto6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class impiegatoEntity {
	
	@Id
	int matricola;
	
	String nome;
	String cognome;
	double salarioMensile;
	public impiegatoEntity() {
		super();
	}
	public impiegatoEntity(int matricola, String nome, String cognome, double salarioMensile) {
		super();
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.salarioMensile = salarioMensile;
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
	public double getSalarioMensile() {
		return salarioMensile;
	}
	public void setSalarioMensile(double salarioMensile) {
		this.salarioMensile = salarioMensile;
	}
	
	
	
	
	

}
