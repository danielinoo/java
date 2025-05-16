package com.spring.progetto5.dto;

public class ProprietarioAnnoDTO {
	
	int annoCreazione;

	String proprietario;

	public ProprietarioAnnoDTO() {
		super();
	}

	public ProprietarioAnnoDTO(int annoCreazione, String proprietario) {
		super();
		this.annoCreazione = annoCreazione;
		this.proprietario = proprietario;
	}

	public int getAnnoCreazione() {
		return annoCreazione;
	}

	public void setAnnoCreazione(int annoCreazione) {
		this.annoCreazione = annoCreazione;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	

}
