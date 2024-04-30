package org.example.practisequerydslcrud.service;

import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import lombok.RequiredArgsConstructor;
import org.example.practisequerydslcrud.dto.request.BooksRequestDto;
import org.example.practisequerydslcrud.dto.response.BookResponseYearDTO;
import org.example.practisequerydslcrud.dto.response.BooksResponseDto;
import org.example.practisequerydslcrud.entity.Books;
import org.example.practisequerydslcrud.exception.custome.NameIsEmptyException;
import org.example.practisequerydslcrud.mapper.ResponseMapper;
import org.example.practisequerydslcrud.repo.BooksRepo;
import org.modelmapper.ModelMapper;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BooksServieImpl implements BooksService {
    private final BooksRepo booksRepo;
    private final ElasticsearchOperations elasticsearchOperations;
    private final ModelMapper modelMapper;
    private final ResponseMapper responseMapper;

    @Override
    public void save(BooksRequestDto booksRequestDto) {
        if (booksRequestDto.name().isEmpty()) {
            throw new NameIsEmptyException("NAME_NOT_SENDING");
        }
        Books books = responseMapper.mapToBooksFromBookResponseDto(booksRequestDto);
//        Books.builder()
//                .name(booksRequestDto.name())
//                .author(booksRequestDto.author())
//                .price(booksRequestDto.price())
//                .publicationYear(booksRequestDto.publicationYear())
//                .build();
        booksRepo.save(books);
    }

    @Override
    public List<BooksResponseDto> getBooksByNameAndAuthor(String name, String author) {
        List<Books> books = booksRepo.findBooksByNameAndAuthor(name, author);
        return books.stream()
                .map(book -> responseMapper.mapToBookResponseDto(book))
                .collect(Collectors.toList());

//                .map(book -> modelMapper.map(book, BooksResponseDto.class)).collect(Collectors.toList());
//                .map(book->BooksResponseDto.builder()
//                        .id(book.getId())
//                        .name(book.getName())
//                        .author(book.getAuthor())
//                        .price(book.getPrice())
//                        .build())
//                .collect(Collectors.toList());
//    }
    }

    @Override
    public List<BooksResponseDto> getBooksByPublicationYear(String year) {
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q.match(m -> m.field("publicationYear").query(year)))
                .build();
        SearchHits<Books> searchHits = elasticsearchOperations.search(query, Books.class);
        return searchHits.getSearchHits().stream()
                .map(s -> responseMapper.mapToBookResponseDto(s.getContent()))
                .toList();

    }

    @Override
    public List<BookResponseYearDTO> getBooksPublicationYearByNameAndAuthor(String name, String author) {



        return null;
    }
}


