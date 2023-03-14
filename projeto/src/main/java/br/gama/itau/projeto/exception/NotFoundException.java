package br.gama.itau.projeto.exception;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String msg){
        super(msg);
    }
}