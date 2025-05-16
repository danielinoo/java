package com.spring.progetto3.professore.dto;

public class ProfessoreDTO {
	
	int id;
	String nome;
	String cognome;
	String materiaInsegnamento;
	public ProfessoreDTO() {
		super();
	}
	public ProfessoreDTO(int id, String nome, String cognome, String materiaInsegnamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.materiaInsegnamento = materiaInsegnamento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getMateriaInsegnamento() {
		return materiaInsegnamento;
	}
	public void setMateriaInsegnamento(String materiaInsegnamento) {
		this.materiaInsegnamento = materiaInsegnamento;
	}
	
	

}
