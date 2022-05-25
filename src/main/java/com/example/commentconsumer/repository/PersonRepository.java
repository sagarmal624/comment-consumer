package com.example.commentconsumer.repository;

import com.example.commentconsumer.model.Comment;
import com.example.commentconsumer.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}
