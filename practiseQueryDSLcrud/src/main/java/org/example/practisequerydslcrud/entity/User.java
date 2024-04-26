package org.example.practisequerydslcrud.entity;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "userIndex")
public class User {
    private String id;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

}
