package com.spring.progetto6.service;


import java.util.List;

import com.spring.progetto6.dto.NomeCognomeDTO;
import com.spring.progetto6.dto.impiegatoDTO;


public interface ImpiegatiService {
	
	public boolean assumi(impiegatoDTO dto);
	
	public impiegatoDTO cerca(int matricola);
	
	public List<impiegatoDTO> visualizza();
	
	public impiegatoDTO elimina(int matricola);
	
	public impiegatoDTO modifica(int matricola,double salario);
	
	
	//elimina impiegato e ritorna nome e cognome
	public NomeCognomeDTO eliminaNC(int matricola);
	
	//lista nome e cognome
	public List<NomeCognomeDTO> visualizzaNC();
	
	//impiegati col salario maggiore rispetto a un salario
	public List<impiegatoDTO> listaSalariMag(double s);
	
	//tutti impiegati ordinati per cognome
	public List<impiegatoDTO> visualizzaPeCognome();
	
	
	//tutti impiegati ordinati pe salario
	public List<impiegatoDTO> visualizzaPeSalario();
	
	

}
