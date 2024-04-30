package org.example.practisequerydslcrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "rajbabu")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Books {
    @Id
    private String id;
    private String name;
    private String author;
    private String publicationYear;
    private Float price;
    private String booksImageUrl;
}
