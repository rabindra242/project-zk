package org.example.practisequerydslcrud.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.http.impl.nio.reactor.ExceptionEvent;
import org.apache.http.protocol.HTTP;
import org.example.practisequerydslcrud.dto.request.BooksRequestDto;
import org.example.practisequerydslcrud.dto.response.BooksResponseDto;
import org.example.practisequerydslcrud.entity.Books;
import org.example.practisequerydslcrud.service.BooksService;
import org.example.practisequerydslcrud.service.BooksServieImpl;
import org.example.practisequerydslcrud.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@CrossOrigin(methods = RequestMethod.GET)
public class BooksController {

    private final BooksService booksService;


    @PostMapping("/post")
    public ResponseEntity<Response<BooksRequestDto>> saveBooks(@RequestBody BooksRequestDto booksRequestDto) {
        booksService.save(booksRequestDto);
        Response<BooksRequestDto> response = new Response<>();
        response.setMessage("Book saved successfully");
        response.setStatus(HttpStatus.OK.value());
        response.setResponse(booksRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-by-name-author")
    public ResponseEntity<Response<?>> getAllBookes(@RequestParam String name,@RequestParam String author){
        Response<List<BooksResponseDto>> response= new Response<>();
        response.setMessage("Book Retrived successfully");
        response.setStatus(HttpStatus.OK.value());
        response.setResponse(booksService.getBooksByNameAndAuthor(name,author));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }








}
