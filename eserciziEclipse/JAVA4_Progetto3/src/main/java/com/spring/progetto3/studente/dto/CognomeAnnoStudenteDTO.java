package com.spring.progetto3.studente.dto;

public class CognomeAnnoStudenteDTO {
	
	int annoNascita;
	String cognome;
	public CognomeAnnoStudenteDTO() {
		super();
	}
	public CognomeAnnoStudenteDTO(int annoNascita, String cognome) {
		super();
		this.annoNascita = annoNascita;
		this.cognome = cognome;
	}
	public int getAnnoNascita() {
		return annoNascita;
	}
	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
}
