package com.spring.progetto5.dto;

import java.util.LinkedList;

public class RubricaDTO {

	int id;

	LinkedList<ContattoDTO> lista = new LinkedList<>();

	int annoCreazione;

	String proprietario;

	public RubricaDTO() {
		super();
	}

	public RubricaDTO(int id, LinkedList<ContattoDTO> lista, int annoCreazione, String proprietario) {
		super();
		this.id = id;
		this.lista = lista;
		this.annoCreazione = annoCreazione;
		this.proprietario = proprietario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<ContattoDTO> getLista() {
		return lista;
	}

	public void setLista(LinkedList<ContattoDTO> lista) {
		this.lista = lista;
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
