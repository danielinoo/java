package com.spring.progetto5.dto;

import java.util.LinkedList;

public class ProprietariNumero {
	
	LinkedList<String> proprietari= new LinkedList<>();
	
	int numeroProprietari;

	public ProprietariNumero() {
		super();
	}

	public ProprietariNumero(LinkedList<String> proprietari, int numeroProprietari) {
		super();
		this.proprietari = proprietari;
		this.numeroProprietari = numeroProprietari;
	}

	public LinkedList<String> getProprietari() {
		return proprietari;
	}

	public void setProprietari(LinkedList<String> proprietari) {
		this.proprietari = proprietari;
	}

	public int getNumeroProprietari() {
		return numeroProprietari;
	}

	public void setNumeroProprietari(int numeroProprietari) {
		this.numeroProprietari = numeroProprietari;
	}
	
	
	
	
	

}
