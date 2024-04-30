package org.example.practisequerydslcrud.service;

import co.elastic.clients.elasticsearch._types.query_dsl.Operator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.practisequerydslcrud.dto.response.BooksResponseDto;
import org.example.practisequerydslcrud.entity.Books;
import org.example.practisequerydslcrud.mapper.ResponseMapper;
import org.example.practisequerydslcrud.repo.BooksRepo;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PractiseServiceImpl {
    private final ElasticsearchOperations elasticsearchOperations;
    private final ResponseMapper responseMapper;


    private final BooksRepo booksRepo;

    public List<BooksResponseDto> searchBookbyAuthor(String author){

        NativeQuery nativeQuery=NativeQuery.builder()
                .withQuery(q->q.match(m->m.field("author").query(author)))
                .build();
        SearchHits<Books> searchHits=elasticsearchOperations.search(nativeQuery, Books.class);
        return searchHits.getSearchHits()
                .stream()
                .map(s->responseMapper.mapToBookResponseDto(s.getContent()))
                .collect(Collectors.toList());
//        return searchHits.getSearchHits()
//                .stream()
//                .map(SearchHit::getContent)
//                .collect(Collectors.toList());
    }

    public List<BooksResponseDto> searchBookbyAuthorUsingOperatorAnd(String author){

        NativeQuery nativeQuery=NativeQuery.builder()
                .withQuery(q->q.match(m->m.field("author").query(author)
                        .operator(Operator.And)))
                .build();
        SearchHits<Books> searchHits=elasticsearchOperations.search(nativeQuery, Books.class);
        return searchHits.getSearchHits()
                .stream()
                .map(s->responseMapper.mapToBookResponseDto(s.getContent()))
                .collect(Collectors.toList());
    }

    //multifield search Query

    public List<BooksResponseDto> searchBooksUsingMultiMatchField(String word,String query){
        NativeQuery nativeQuery=NativeQuery.builder()
                .withQuery(m->m.multiMatch(f->f.fields("author","name").query(word).query(query)))
                .build();
        SearchHits<Books> searchHits=elasticsearchOperations.search(nativeQuery, Books.class);
        return searchHits.getSearchHits()
                .stream()
                .map(s->responseMapper.mapToBookResponseDto(s.getContent()))
                .collect(Collectors.toList());

    }

    public List<BooksResponseDto> searchBooksUsingBoolQuery(String author){
        NativeQuery nativeQuery = NativeQuery.builder()
                .withQuery(b->b.bool(m->m.must(ma->ma.match(f->f.field("name").query(author)
                        .operator(Operator.And)))))
                .build();
        SearchHits<Books> searchHits=elasticsearchOperations.search(nativeQuery, Books.class);
        return searchHits.getSearchHits()
                .stream()
                .map(s->responseMapper.mapToBookResponseDto(s.getContent()))
                .collect(Collectors.toList());
    }

//    public List<BooksResponseDto> searchBooksUsiningMultipleLeafQuerues(String author,String name){
//        NativeQuery nativeQuery=NativeQuery.builder()
//                .withQuery(b->b.bool(m->m.must(
//                        ma->ma
//                                .match(f->f.field("author").query(author)))))
//    }
}
