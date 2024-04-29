package org.example.practisequerydslcrud.repo;

import org.example.practisequerydslcrud.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepo extends ElasticsearchRepository<User,String> {
    Optional<User> findByEmail(String username);
}
