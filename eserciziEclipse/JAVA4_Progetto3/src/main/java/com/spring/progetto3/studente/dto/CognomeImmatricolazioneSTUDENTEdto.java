package com.spring.progetto3.studente.dto;

public class CognomeImmatricolazioneSTUDENTEdto {


	
	int annoImmatricolazione;
	String cognome;
	public CognomeImmatricolazioneSTUDENTEdto() {
		super();
	}
	public CognomeImmatricolazioneSTUDENTEdto(int annoImmatricolazione, String cognome) {
		super();
		this.annoImmatricolazione = annoImmatricolazione;
		this.cognome = cognome;
	}
	public int getannoImmatricolazione() {
		return annoImmatricolazione;
	}
	public void setannoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
}
