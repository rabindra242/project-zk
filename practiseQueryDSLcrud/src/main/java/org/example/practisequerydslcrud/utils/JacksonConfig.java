package org.example.practisequerydslcrud.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.practisequerydslcrud.dto.response.BooksResponseDto;
import org.example.practisequerydslcrud.entity.Books;
import org.example.practisequerydslcrud.mapper.ResponseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }



}

