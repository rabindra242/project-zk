package org.example.practisequerydslcrud.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.practisequerydslcrud.dto.response.BooksResponseDto;
import org.example.practisequerydslcrud.service.PractiseServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Slf4j
public class PractiseController {
    private final PractiseServiceImpl practiseServiceImpl;

    @GetMapping
    public List<BooksResponseDto> requestController(@RequestParam(name = "word")String word,@RequestParam("word1")String word1){
      return   practiseServiceImpl.searchBooksUsingMultiMatchField(word,word1);



    }
}
