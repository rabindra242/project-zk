package org.example.practisequerydslcrud.exception.global;

import org.example.practisequerydslcrud.exception.custome.NameIsEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class BookNameIsEmpty {

    @ExceptionHandler(NameIsEmptyException.class)
    public ResponseEntity<String> handleEmptyName(NameIsEmptyException nameIsEmptyException){
        return new ResponseEntity<>("Name is Empty", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> getAuthorByName(NoSuchElementException noSuchElementException){
        return new ResponseEntity<>("No such Name Found in DB",HttpStatus.BAD_REQUEST);
    }

}
