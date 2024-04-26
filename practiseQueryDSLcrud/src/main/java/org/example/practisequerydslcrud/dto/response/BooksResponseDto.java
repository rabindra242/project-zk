package org.example.practisequerydslcrud.dto.response;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record BooksResponseDto(String id, String name, String author, Float price) implements Serializable {
}


