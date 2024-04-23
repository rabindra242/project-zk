package org.example.practisequerydslcrud.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.practisequerydslcrud.dto.request.BooksRequestDto;
import org.example.practisequerydslcrud.dto.response.BooksResponseDto;
import org.example.practisequerydslcrud.entity.Books;
import org.example.practisequerydslcrud.repo.BooksRepo;
import org.modelmapper.ModelMapper;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BooksServieImpl implements BooksService {
    private final BooksRepo booksRepo;
    private final ElasticsearchOperations elasticsearchOperations;
    private final ModelMapper modelMapper;

    @Override
    public void save(BooksRequestDto booksRequestDto) {
        Books books = Books.builder()
                .name(booksRequestDto.getName())
                .author(booksRequestDto.getAuthor())
                .price(booksRequestDto.getPrice())
                .publicationYear(booksRequestDto.getPublicationYear())
                .build();
         booksRepo.save(books);
    }

    @Override
    public List<BooksResponseDto> getBooksByNameAndAuthor(String name, String author) {
        List<Books> books=booksRepo.findBooksByNameAndAuthor(name,author);
        return books.stream()
                .map(book -> modelMapper.map(book, BooksResponseDto.class)).collect(Collectors.toList());
    }


}
