package com.spring.esercizio5.entity;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class rubricaEntity {
	
	@Id
	private int id;
	
	private String proprietario;
	private int annoCreazione;
	
	
	
	//	@OneToMany(cascade = CascadeType.PERSIST) --> INSERISCE IN AUTOMATICO I CONTATTI NELLA LISTA (NEL DB)
	// @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true) --> quando elimino la rubrica elimina direttamente pure i contatti presenti
	// cascade = CascadeType.ALL -->  esegue tutte le azioni (persiste,remove)
	// @JoinColumn(name = "fk_rubrica") --> dice che la lista contatti è la foreing key
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_rubrica")
	private List<contattoEntity> contatti = new ArrayList<>();



	public rubricaEntity() {
		super();
	}



	public rubricaEntity(int id, String proprietario, int annoCreazione) {
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



	public List<contattoEntity> getContatti() {
		return contatti;
	}



	public void setContatti(List<contattoEntity> contatti) {
		this.contatti = contatti;
	}
	
	
	
	
	//aggiung il metodo di business
	public void aggiungiContatto(contattoEntity entity) {
		contatti.add(entity);
	}


}
