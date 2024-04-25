package org.example.practisequerydslcrud.repo;

import org.example.practisequerydslcrud.entity.Books;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BooksRepo extends ElasticsearchRepository<Books,String> {

    List<Books> findBooksByNameAndAuthor(String name,String author);

}
