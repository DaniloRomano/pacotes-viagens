package br.ufms.danilo.pacotesviagensapi.exceptions;

public class BadRequestException extends Exception{
    public BadRequestException(String message){
        super(message);
    }
}
