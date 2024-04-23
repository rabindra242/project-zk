package org.example.practisequerydslcrud.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BooksRequestDto {
    private String name;
    private String author;
    private String publicationYear;
    private Float price;
}
