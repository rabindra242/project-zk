package org.example.practisequerydslcrud.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import lombok.RequiredArgsConstructor;
import org.example.practisequerydslcrud.entity.Books;
import org.example.practisequerydslcrud.service.ElasticSearch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class SearchController {
    private final ElasticSearch elasticSearch;

    @GetMapping("/autoSuggest/{partialProductName}")
    List<String> autoSuggestProductSearch(@PathVariable String partialProductName) throws IOException {
        SearchResponse<Books> searchResponse = elasticSearch.autoSuggestProduct(partialProductName);
        List<Hit<Books>> hitList  =  searchResponse.hits().hits();
        List<Books> productList = new ArrayList<>();
        for(Hit<Books> hit : hitList){
            productList.add(hit.source());
        }
        List<String> listOfProductNames = new ArrayList<>();
        for(Books product : productList){
            listOfProductNames.add(product.getName())  ;
        }
        return listOfProductNames;
    }
}
