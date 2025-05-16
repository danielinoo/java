package com.spring.esercizio4Studenti.service;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.esercizio4Studenti.dao.daoStudente;
import com.spring.esercizio4Studenti.dto.StudenteDTO;
import com.spring.esercizio4Studenti.entity.Studente;

import org.springframework.transaction.annotation.Transactional;



//@Transactional  --> serve per gestire gli errori (ti riporta alla versione precedente)

@Service
@Transactional 
public class service implements serviceStudenti {
	

	@Autowired
	private daoStudente dao;

	@Override
	public boolean immatricola(StudenteDTO dto) {
		// TODO Auto-generated method stub
		
		
		//conversione studenteDTO a studenteEntity
		Studente st = new Studente(dto.getMatricola(), dto.getNome(), dto.getCognome(),dto.getAnnoImm());
		
		
		//OPtional ---> se non c è lo studente dentro il db ti ritorna false
		Optional <Studente> opt = dao.findById(dto.getMatricola());
		if(opt.isPresent())
			return false;
		else {   
			//salvo il nuovo studente del db
			dao.save(st);
				return true;
		}
	
	}

	@Override
	public StudenteDTO cerca(int matricola) {
		Optional <Studente> opt = dao.findById(matricola);
		if(opt.isPresent()) {
			//se l id è presente con opt.get() prendo l entity e lo ritorno convertito in dto
			Studente st = opt.get();  
			return new  StudenteDTO(matricola, st.getNome(), st.getCognome(), st.getAnnoImm());
		}else {   
				return null;
		}
	
	}

	@Override
	public LinkedList<StudenteDTO> visualizza() {
		LinkedList<StudenteDTO> listaDTO = new LinkedList<>();
		List<Studente> lista = dao.findAll();
		
		for (Studente st : lista) {
			listaDTO.add(new  StudenteDTO(st.getMatricola(), st.getNome(), st.getCognome(), st.getAnnoImm()));
		}
		return listaDTO;
	}

	@Override
	public StudenteDTO elimina(int matricola) {
		
		Optional <Studente> opt = dao.findById(matricola);
		if(opt.isPresent()) {
			
			//se è presente l utente lo elimino lo ritorno
			Studente st = opt.get();
			dao.delete(st);
			return new  StudenteDTO(matricola, st.getNome(), st.getCognome(), st.getAnnoImm());
		
		
		}else {   
				return null;
		}
	}

	@Override
	public List<StudenteDTO> getGiovani(int annoimmatr) {
		List<Studente> lista = dao.getGiovani(annoimmatr);
		
		//trasformazione
		
		//stream --> prende la lista di StudenteEntity
		//map --> converte il singolo studenteEntity (dentro la lista) in studenteDTO
		//collect --> inserisce i dto in una lista
		
		return lista.stream()
				.map(studente -> new StudenteDTO(studente.getMatricola(), studente.getNome(), studente.getCognome(),studente.getAnnoImm()))
				.collect(Collectors.toList());
	
	
	}

}
