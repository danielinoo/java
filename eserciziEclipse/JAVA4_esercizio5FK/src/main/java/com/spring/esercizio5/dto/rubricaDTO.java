package com.spring.esercizio5.dto;

import java.util.ArrayList;
import java.util.List;

public class rubricaDTO {

	private int id;

	private String proprietario;
	private int annoCreazione;

	private List<contattoDTO> contatti = new ArrayList<>();

	public rubricaDTO() {
		super();
	}

	public rubricaDTO(int id, String proprietario, int annoCreazione) {
		super();
		this.id = id;
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public int getAnnoCreazione() {
		return annoCreazione;
	}

	public void setAnnoCreazione(int annoCreazione) {
		this.annoCreazione = annoCreazione;
	}

	public List<contattoDTO> getContatti() {
		return contatti;
	}

	public void setContatti(List<contattoDTO> contatti) {
		this.contatti = contatti;
	}

	// aggiung il metodo di business
	public void aggiungiContatto(contattoDTO DTO) {
			contatti.add(DTO);
		}

}


