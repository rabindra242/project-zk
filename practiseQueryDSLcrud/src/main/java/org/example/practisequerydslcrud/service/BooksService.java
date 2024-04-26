package org.example.practisequerydslcrud.service;

import org.example.practisequerydslcrud.dto.request.BooksRequestDto;
import org.example.practisequerydslcrud.dto.response.BookResponseYearDTO;
import org.example.practisequerydslcrud.dto.response.BooksResponseDto;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;

public interface BooksService {
    void save(BooksRequestDto booksRequestDto);

    List<BooksResponseDto> getBooksByNameAndAuthor(String name, String author);

    List<BooksResponseDto> getBooksByPublicationYear(String year);

    List<BookResponseYearDTO> getBooksPublicationYearByNameAndAuthor(String name, String Author);

}
