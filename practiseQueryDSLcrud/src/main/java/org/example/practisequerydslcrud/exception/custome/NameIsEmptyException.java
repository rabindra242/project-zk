package org.example.practisequerydslcrud.exception.custome;

public class NameIsEmptyException extends RuntimeException{
    public NameIsEmptyException() {
    }

    public NameIsEmptyException(String message) {
        super(message);
    }
}
