package com.spring.progetto5.entity;

import java.util.LinkedList;

public class RubricaEntity {

	int id;

	LinkedList<ContattoEntity> lista = new LinkedList<>();

	int annoCreazione;

	String proprietario;

	public RubricaEntity() {
		super();
	}

	public RubricaEntity(int id, LinkedList<ContattoEntity> lista, int annoCreazione, String proprietario) {
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

	public LinkedList<ContattoEntity> getLista() {
		return lista;
	}

	public void setLista(LinkedList<ContattoEntity> lista) {
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
