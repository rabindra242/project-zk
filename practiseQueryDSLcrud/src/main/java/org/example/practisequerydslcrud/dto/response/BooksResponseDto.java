package org.example.practisequerydslcrud.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksResponseDto {
    private String id;
    private String name;
    private String author;
    private String price;
}
