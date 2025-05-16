package com.spring.esercizio5.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.esercizio5.dao.daoRubrica;
import com.spring.esercizio5.dto.contattoDTO;
import com.spring.esercizio5.dto.rubricaDTO;
import com.spring.esercizio5.entity.contattoEntity;
import com.spring.esercizio5.entity.rubricaEntity;
import com.spring.esercizio5.utility.ConversioniCont2;
import com.spring.esercizio5.utility.ConversioniRub2;

@Service
@Transactional
public class service implements Rub2service {

	@Autowired
	daoRubrica dao;

	@Override
	public boolean creaRubrica(rubricaDTO dto) {
		Optional<rubricaEntity> opt = dao.findById(dto.getId());
		if (opt.isPresent())
			throw new RuntimeException("la rubrica è già presente");
		else {
			rubricaEntity entity = ConversioniRub2.da_Dto_A_Entity(dto);
			dao.save(entity);
			return true;
		}

	}

	@Override
	public rubricaDTO cerca(int id) {
		Optional<rubricaEntity> opt = dao.findById(id);

		if (opt.isPresent()) {
			rubricaEntity entity = opt.get();
			rubricaDTO dto = ConversioniRub2.daRubricaARubricaDto(entity);
			return dto;

		} else {
			throw new RuntimeException("la rubrica da cercare non esiste");
		}

	}

	@Override
	public boolean aggContatto(int id, contattoDTO dto) {
		Optional<rubricaEntity> opt = dao.findById(id);

		if (opt.isPresent()) {
			rubricaEntity entity = opt.get();

			entity.aggiungiContatto(ConversioniCont2.da_DTO_a_Entity(dto));
			return true;

		} else {
			throw new RuntimeException("il contatto è già presente");
		}

	}

	@Override
	public List<rubricaDTO> mostraRubriche() {
		List<rubricaEntity> listaEntity = dao.findAll();

		List<rubricaDTO> listaDTO = listaEntity.stream()
				.map(rubrica_entity -> ConversioniRub2.daRubricaARubricaDto(rubrica_entity))
				.collect(Collectors.toList());
		return listaDTO;
	}

	@Override
	public rubricaDTO rimuoviRubrica(int idrDTO) {
		Optional<rubricaEntity> opt = dao.findById(idrDTO);

		if (opt.isPresent()) {
			rubricaEntity entity = opt.get();

			dao.deleteById(idrDTO);

			return ConversioniRub2.daRubricaARubricaDto(entity);

		} else {
			throw new RuntimeException("la rubrica da eliminare non esiste");
		}
	}

	@Override
	public contattoDTO cercaContatto(int id, int IDcontatto) {
		Optional<rubricaEntity> opt = dao.findById(id);

		if (opt.isPresent()) {
			rubricaEntity entity = opt.get();
			for (contattoEntity c : entity.getContatti()) {
				if (c.getId() == IDcontatto) {
					return ConversioniCont2.da_Entity_a_DTO(c);
				}
			}
			throw new RuntimeException("il contatto da cercare non esiste");

		}
		throw new RuntimeException("la rubrica non esiste");
	}

	@Override
	public contattoDTO eliminaContatto(int id, int IDcontatto) {
		Optional<rubricaEntity> opt = dao.findById(id);

		if (opt.isPresent()) {
			rubricaEntity entity = opt.get();
			for (contattoEntity c : entity.getContatti()) {
				if (c.getId() == IDcontatto) {
					entity.getContatti().remove(c);
					return ConversioniCont2.da_Entity_a_DTO(c);
				}
			}
			throw new RuntimeException("il contatto da eliminare non esiste");

		}
		throw new RuntimeException("la rubrica  non esiste");
	}

	@Override
	public List<contattoDTO> VisualizzaContatti(int id) {
		Optional<rubricaEntity> opt = dao.findById(id);

		if (opt.isPresent()) {
			rubricaEntity entity = opt.get();
			rubricaDTO dto = ConversioniRub2.daRubricaARubricaDto(entity);
			return dto.getContatti();

		} else {
			throw new RuntimeException("la rubrica non esiste");
		}

	}

	@Override
	public rubricaDTO modificaAnnoCreazione(int idRubrica, int NuovoAnno) {
		Optional<rubricaEntity> opt = dao.findById(idRubrica);

		if (opt.isPresent()) {
			rubricaEntity entity = opt.get();
			entity.setAnnoCreazione(NuovoAnno);
			rubricaDTO dto = ConversioniRub2.daRubricaARubricaDto(entity);
			return dto;

		} else {
			throw new RuntimeException("la rubrica non esiste");
		}

	}

	@Override
	public int NumeroContattiGruppo(int id, String gruppo) {
		Optional<rubricaEntity> opt = dao.findById(id);

		if (opt.isPresent()) {
			rubricaEntity entity = opt.get();
			rubricaDTO dto = ConversioniRub2.daRubricaARubricaDto(entity);
			return dto.getContatti().size();

		} else {
			throw new RuntimeException("la rubrica non esiste");
		}
	}

	@Override
	public contattoDTO modificaContatto(int id, contattoDTO nuovoDTO) {

		Optional<rubricaEntity> opt = dao.findById(id);

		if (opt.isPresent()) {
			rubricaEntity entity = opt.get();
			for (contattoEntity c : entity.getContatti()) {
				if(c.getId() == nuovoDTO.getId()) {
					c.setNome(nuovoDTO.getNome());
					c.setCognome(nuovoDTO.getCognome());
					c.setNumero(nuovoDTO.getNumero());
					return ConversioniCont2.da_Entity_a_DTO(c);
				}
				
			}
		}else {
			throw new RuntimeException("l' id del contatto da modificare non esiste");
				
			}

		throw new RuntimeException("la rubrica non esiste");
	}

}
