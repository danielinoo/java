package com.spring.progetto2.dto;

import java.util.List;

public class ReportDTO {
	
	
	List<String> descrizioni;
	int pezzi_tot;
	int numero_prodotti_non_disponibili;
	double media_prezzi;
	List<String> elenco_prodottti_non_disponibili;
	public ReportDTO() {
		super();
	}
	public ReportDTO(List<String> descrizioni, int pezzi_tot, int numero_prodotti_non_disponibili, double media_prezzi,
			List<String> elenco_prodottti_non_disponibili) {
		super();
		this.descrizioni = descrizioni;
		this.pezzi_tot = pezzi_tot;
		this.numero_prodotti_non_disponibili = numero_prodotti_non_disponibili;
		this.media_prezzi = media_prezzi;
		this.elenco_prodottti_non_disponibili = elenco_prodottti_non_disponibili;
	}
	public List<String> getDescrizioni() {
		return descrizioni;
	}
	public void setDescrizioni(List<String> descrizioni) {
		this.descrizioni = descrizioni;
	}
	public int getPezzi_tot() {
		return pezzi_tot;
	}
	public void setPezzi_tot(int pezzi_tot) {
		this.pezzi_tot = pezzi_tot;
	}
	public int getNumero_prodotti_non_disponibili() {
		return numero_prodotti_non_disponibili;
	}
	public void setNumero_prodotti_non_disponibili(int numero_prodotti_non_disponibili) {
		this.numero_prodotti_non_disponibili = numero_prodotti_non_disponibili;
	}
	public double getMedia_prezzi() {
		return media_prezzi;
	}
	public void setMedia_prezzi(double media_prezzi) {
		this.media_prezzi = media_prezzi;
	}
	public List<String> getElenco_prodottti_non_disponibili() {
		return elenco_prodottti_non_disponibili;
	}
	public void setElenco_prodottti_non_disponibili(List<String> elenco_prodottti_non_disponibili) {
		this.elenco_prodottti_non_disponibili = elenco_prodottti_non_disponibili;
	}
	
	
	
	
	

}
