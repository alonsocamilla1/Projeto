package br.gama.itau.projeto.exception;

public class NotFoundException extends RuntimeException {
    
    // Método que mostra a mensagem personalizada da exceção
    public NotFoundException(String msg){
        super(msg);
    }
}
