package org.example.practisequerydslcrud.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Response<T> {
    private String message;
    private int status;
    private T response;
}
