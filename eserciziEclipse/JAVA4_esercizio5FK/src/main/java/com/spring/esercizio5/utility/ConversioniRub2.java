package com.spring.esercizio5.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.esercizio5.dto.contattoDTO;
import com.spring.esercizio5.dto.rubricaDTO;
import com.spring.esercizio5.entity.contattoEntity;
import com.spring.esercizio5.entity.rubricaEntity;

public class ConversioniRub2 {


    public static rubricaEntity da_Dto_A_Entity(rubricaDTO dto) {
       rubricaEntity entity = new rubricaEntity(dto.getId(), dto.getProprietario(), dto.getAnnoCreazione());
        
        // converto la lista
        List<contattoDTO> listaDTO = dto.getContatti();
        
        List<contattoEntity> listaEntity = listaDTO.stream()
                .map(contatto_dto -> ConversioniCont2.da_DTO_a_Entity(contatto_dto))
                .collect(Collectors.toList());
        
        entity.setContatti(listaEntity);
        return entity;
        
    }
    
    public static rubricaDTO daRubricaARubricaDto(rubricaEntity entity) {
        rubricaDTO dto = new rubricaDTO(entity.getId(), entity.getProprietario(), entity.getAnnoCreazione());
        
        // converto la lista
        List<contattoEntity> listaEntity = entity.getContatti();
        
        List<contattoDTO> listaDTO = listaEntity.stream()
                .map(contatto_entity -> ConversioniCont2.da_Entity_a_DTO(contatto_entity))
                .collect(Collectors.toList());
        
        dto.setContatti(listaDTO);
        return dto;
        
    }



}
