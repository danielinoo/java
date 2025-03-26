package com.spring.progetto1.dto;

import java.util.LinkedList;

public class ListaNomeCognomeDTO {
	LinkedList<NomeCognomeDTO> lista;
	int numero_utenti_registrati;

	public ListaNomeCognomeDTO() {
		super();
	}

	public ListaNomeCognomeDTO(LinkedList<NomeCognomeDTO> lista, int numero_utenti_registrati) {
		super();
		this.lista = lista;
		this.numero_utenti_registrati = numero_utenti_registrati;
	}

	public LinkedList<NomeCognomeDTO> getLista() {
		return lista;
	}

	public void setLista(LinkedList<NomeCognomeDTO> lista) {
		this.lista = lista;
	}

	public int getContatore() {
		return numero_utenti_registrati;
	}

	public void setContatore(int numero_utenti_registrati) {
		this.numero_utenti_registrati = numero_utenti_registrati;
	}

}
