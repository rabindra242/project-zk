package org.example.practisequerydslcrud.mapper;

import org.example.practisequerydslcrud.dto.request.BooksRequestDto;
import org.example.practisequerydslcrud.dto.response.BooksResponseDto;
import org.example.practisequerydslcrud.entity.Books;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResponseMapper {
    BooksResponseDto mapToBookResponseDto(Books books);
    Books mapToBooksFromBookResponseDto(BooksRequestDto booksRequestDto);
}
