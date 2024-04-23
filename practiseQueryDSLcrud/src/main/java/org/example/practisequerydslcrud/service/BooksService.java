package org.example.practisequerydslcrud.service;

import org.example.practisequerydslcrud.dto.request.BooksRequestDto;
import org.example.practisequerydslcrud.dto.response.BooksResponseDto;
import org.example.practisequerydslcrud.utils.Response;

import java.util.List;

public interface BooksService {
//    List<Books> getAllBooks();
//    List<Books> findAllBooksByAge(Integer age);
//
//    List<Books> findBooksByAuthor();
    void save(BooksRequestDto booksRequestDto);

    List<BooksResponseDto> getBooksByNameAndAuthor(String name, String author);

}
