package br.gama.itau.projeto.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .titulo("Erro na solicitacao")
                .mensagem(ex.getMessage())
                .codigoStatus(HttpStatus.NOT_FOUND.value())
                .build();

        // exceptionDetails.setTitulo("Erro na solicitação");
        // exceptionDetails.setMensagem(ex.getMessage());
        // exceptionDetails.setCodigoStatus(HttpStatus.NOT_FOUND.value());
        // exceptionDetails.setTimestamp(LocalDate.now());

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);

    }
}
