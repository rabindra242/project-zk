package org.example.practisequerydslcrud.utils;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;

import java.util.function.Supplier;

public class ElasticUtil {

    public static Supplier<Query> createSupplierAutoSuggest(String partialBooksName){
        Supplier<Query> supplier=()->Query.of(q->q.match(createAutoSuggestion(partialBooksName)));
        return supplier;

    }

    public static MatchQuery createAutoSuggestion(String partialBooksName){
        val autoSuggestionQuery=new MatchQuery.Builder();
        return autoSuggestionQuery.field("name").query(partialBooksName)
                .analyzer("standard").build();
    }


}
