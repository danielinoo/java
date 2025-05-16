package com.spring.esameJava.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.esameJava.dto.prodottoDTO;
import com.spring.esameJava.dto.venditoreDTO;
import com.spring.esameJava.dto.venditoreSPdto;
import com.spring.esameJava.entity.prodotto;
import com.spring.esameJava.entity.venditore;
public class ConversioniVenditori {
	
	
    public static venditore da_Dto_A_Entity(venditoreDTO dto) {
        venditore entity = new venditore(dto.getId(), dto.getNome(),dto.getCognome(),dto.getPassword(),dto.getVia(),dto.getCitta());
         
         // converto la lista di prodotti da entity a dto
         List<prodottoDTO> listaDTO = dto.getProdottiDTO();
         
         List<prodotto> listaEntity = listaDTO.stream()
                 .map(prod_dto -> ConversioniProdotto.da_DTO_a_Entity(prod_dto))
                 .collect(Collectors.toList());
         
         entity.setProdotti(listaEntity);
         return entity;
         
     }
    
    public static venditoreDTO da_Entity_A_Dto(venditore entity) {
        venditoreDTO dto = new venditoreDTO(entity.getId(), entity.getNome(),entity.getCognome(),entity.getPassword(),entity.getVia(),entity.getCitta());
        
       
        List<prodotto> listaEntity = entity.getProdotti();
        
        List<prodottoDTO> listaDTO = listaEntity.stream()
                .map(prod_entity -> ConversioniProdotto.da_Entity_a_DTO(prod_entity))
                .collect(Collectors.toList());
        
        dto.setProdotti(listaDTO);
        return dto;
        
    }
    
    public static venditoreSPdto da_entity_a_VenditoreSenzaProdotti(venditore entity) {
        venditoreSPdto SPdto = new venditoreSPdto(entity.getId(), entity.getNome(),entity.getCognome(),entity.getPassword(),entity.getVia(),entity.getCitta());
		return SPdto;
        
    }
}
