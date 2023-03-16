package br.gama.itau.projeto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerErrorException;


public class InternalServerErrorException  extends RuntimeException   {
    
    public InternalServerErrorException( String message){
        super(message);
    }
}
