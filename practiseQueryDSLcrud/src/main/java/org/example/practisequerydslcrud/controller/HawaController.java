package org.example.practisequerydslcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HawaController {
    @GetMapping
    public String get(){
        return "Hello Mf";
    }
}
