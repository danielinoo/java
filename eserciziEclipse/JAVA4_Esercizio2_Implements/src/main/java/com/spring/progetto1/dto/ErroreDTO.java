package com.spring.progetto1.dto;

public class ErroreDTO {

    private String messaggio;
    
    

    public ErroreDTO(String messaggio) {
        super();
        this.messaggio = messaggio;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }
    
    
    
}