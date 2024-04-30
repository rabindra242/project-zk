package org.example.practisequerydslcrud.service;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import org.example.practisequerydslcrud.entity.Books;

import java.io.IOException;

public interface ElasticSearch {

    public SearchResponse<Books> autoSuggestProduct(String partialProductName) throws IOException;
}
