package com.aluraone.forum.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TrataErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity trataErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity trataErro400(MethodArgumentNotValidException ex){

        var erros = ex.getFieldErrors();
        var listaDadosErros = erros.stream().map(DadosErroValidacao::new).toList();

     return ResponseEntity.badRequest().body(listaDadosErros);

    }

    //Record que é usao só na classe TrataErro

    private record DadosErroValidacao(String campo, String message){

        DadosErroValidacao(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}


