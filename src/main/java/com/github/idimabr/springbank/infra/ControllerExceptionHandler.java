package com.github.idimabr.springbank.infra;

import com.github.idimabr.springbank.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.OptionalDataException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário já cadastrado no sistema.", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threatNotFound(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity threatRequestMethod(HttpRequestMethodNotSupportedException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Método de requisição não aceito.", "404");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}
