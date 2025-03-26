package com.spring.progetto5.dto;

public class ContattiProprietario {
	

	String proprietario;
	int NumeroContatti;
	public ContattiProprietario() {
		super();
	}
	public ContattiProprietario(String proprietario, int numeroContatti) {
		super();
		this.proprietario = proprietario;
		NumeroContatti = numeroContatti;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public int getNumeroContatti() {
		return NumeroContatti;
	}
	public void setNumeroContatti(int numeroContatti) {
		NumeroContatti = numeroContatti;
	}
	
	

}
