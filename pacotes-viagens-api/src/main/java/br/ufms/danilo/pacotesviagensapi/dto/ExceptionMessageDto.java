package br.ufms.danilo.pacotesviagensapi.dto;

import org.springframework.http.HttpStatus;

public class ExceptionMessageDto {
    
    private int status;
    private String message;

    public ExceptionMessageDto setMessage(String message){
        this.message=message;
        return this;
    }

    public ExceptionMessageDto setStatus(HttpStatus status){
        this.status=status.value();
        return this;
    }

    public ExceptionMessageDto build(){
        return this;
    }
    
}
