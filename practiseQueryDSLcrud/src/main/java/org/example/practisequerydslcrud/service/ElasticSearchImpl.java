package org.example.practisequerydslcrud.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.example.practisequerydslcrud.entity.Books;
import org.example.practisequerydslcrud.utils.ElasticUtil;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.function.Supplier;


@Service
@RequiredArgsConstructor
public class ElasticSearchImpl implements ElasticSearch{
    private final ElasticsearchClient elasticsearchClient;
    private final ElasticsearchOperations elasticsearchOperations;
    @Override
    public SearchResponse<Books> autoSuggestProduct(String partialProductName) throws IOException {
        Supplier<Query> supplier= ElasticUtil.createSupplierAutoSuggest(partialProductName);
        SearchResponse<Books> searchResponse=elasticsearchClient
                .search(s->s.index("rajbabu").query(supplier.get()), Books.class);
        System.out.println("elasticsearch autosuggestion query"+supplier.get().toString());
        return searchResponse;
    }
}
