package com.spring.progetto6.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.progetto6.dao.ImpiegatiDao;
import com.spring.progetto6.dto.NomeCognomeDTO;
import com.spring.progetto6.dto.impiegatoDTO;
import com.spring.progetto6.entity.impiegatoEntity;
import com.spring.progetto6.utility.ConversioniImp;

@Service
@Transactional
public class service implements ImpiegatiService {

	@Autowired
	ImpiegatiDao dao;

	@Override
	public boolean assumi(impiegatoDTO dto) {

		Optional<impiegatoEntity> opt = dao.findById(dto.getMatricola());
		if (opt.isPresent())
			throw new RuntimeException("l'impiegato è già presente");
		else {
			
			System.out.println("dto" + dto.getNome());

			impiegatoEntity imp = ConversioniImp.da_DTO_a_Entity(dto);
			// salvo il nuovo impiegato del db
			
			System.out.println("imp" + imp.getNome());
			dao.save(imp);
			return true;
		}
	}

	@Override
	public impiegatoDTO cerca(int matricola) {
		Optional<impiegatoEntity> opt = dao.findById(matricola);
		if (opt.isPresent()) {
			impiegatoEntity entity = opt.get();
			impiegatoDTO imp = ConversioniImp.da_Entity_a_DTO(entity);

			return imp;

		} else {

			throw new RuntimeException("l' id dell' impiegato inserito è sbagliato");
		}
	}

	@Override
	public List<impiegatoDTO> visualizza() {
		List<impiegatoEntity> listaEntity = dao.findAll();

		return listaEntity.stream()
				.map(impiegatoEntity -> new impiegatoDTO(impiegatoEntity.getMatricola(), impiegatoEntity.getNome(),
						impiegatoEntity.getCognome(), impiegatoEntity.getSalarioMensile()))
				.collect(Collectors.toList());

	}

	@Override
	public impiegatoDTO elimina(int matricola) {
		Optional<impiegatoEntity> opt = dao.findById(matricola);
		if (opt.isPresent()) {
			impiegatoEntity entity = opt.get();
			dao.delete(entity);
			impiegatoDTO imp = ConversioniImp.da_Entity_a_DTO(entity);
			return imp;

		} else {

			throw new RuntimeException("l' id dell' impiegato che si vuole eliminare è sbagliato");
		}

	}

	@Override
	public impiegatoDTO modifica(int matricola, double salario) {
		Optional<impiegatoEntity> opt = dao.findById(matricola);
		if (opt.isPresent()) {
			impiegatoEntity entity = opt.get();
			entity.setSalarioMensile(salario);
			impiegatoDTO imp = ConversioniImp.da_Entity_a_DTO(entity);

			return imp;

		} else {

			throw new RuntimeException("errore durante la modifica del salario");
		}
	}

	//elimina impiegato e ritorna nome e cognome
	@Override
	public NomeCognomeDTO eliminaNC(int matricola) {
		Optional<impiegatoEntity> opt = dao.findById(matricola);
		if (opt.isPresent()) {
			impiegatoEntity entity = opt.get();
			dao.delete(entity);
			NomeCognomeDTO imp = ConversioniImp.da_Entity_a_NomeCognomeDTO(entity);
			return imp;

		} else {

			throw new RuntimeException("errore durante l' eliminazione dell'impiegato");
		}
	}

	//lista nome e cognome
	@Override
	public List<NomeCognomeDTO> visualizzaNC() {
		List<impiegatoEntity> listaEntity = dao.findAll();

		return listaEntity.stream()
				.map(impiegatoEntity -> new NomeCognomeDTO( impiegatoEntity.getNome(),impiegatoEntity.getCognome()))
				.collect(Collectors.toList());
	}

	@Override
	public List<impiegatoDTO> listaSalariMag(double s) {
	List<impiegatoEntity> listaEntity = dao.getSalario(s);
	List<impiegatoDTO> listaDTO = new ArrayList<>();
	
	for (impiegatoEntity i : listaEntity) {
		listaDTO.add(ConversioniImp.da_Entity_a_DTO(i));
		
	}
	return listaDTO;
	}

	
	//tutti impiegati ordinati per cognome
	@Override
	public List<impiegatoDTO> visualizzaPeCognome() {
		List<impiegatoEntity> listaEntity = dao.getByCognome();
		return listaEntity.stream()
				.map(impiegatoEntity -> new impiegatoDTO(impiegatoEntity.getMatricola(), impiegatoEntity.getNome(),
						impiegatoEntity.getCognome(), impiegatoEntity.getSalarioMensile()))
				.collect(Collectors.toList());

	}

	
	
	//tutti impiegati ordinati pe salario
	@Override
	public List<impiegatoDTO> visualizzaPeSalario() {
		List<impiegatoEntity> listaEntity = dao.findAll();
		
		 Collections.sort(listaEntity, Comparator.comparingDouble(impiegatoEntity::getSalarioMensile));

		
		return listaEntity.stream()
				.map(impiegatoEntity -> new impiegatoDTO(impiegatoEntity.getMatricola(), impiegatoEntity.getNome(),
						impiegatoEntity.getCognome(), impiegatoEntity.getSalarioMensile()))
				.collect(Collectors.toList());
	}

	

}
