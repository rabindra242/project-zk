package org.example.practisequerydslcrud.dto.request;


import lombok.Builder;

@Builder
public record BooksRequestDto(
        String name,String author,String publicationYear,Float price){
}