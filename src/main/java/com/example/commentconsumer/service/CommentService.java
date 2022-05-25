package com.example.commentconsumer.service;

import com.example.commentconsumer.model.Comment;
import com.example.commentconsumer.model.CommentRequestMessage;
import com.example.commentconsumer.model.Person;
import com.example.commentconsumer.repository.CommentRepository;
import com.example.commentconsumer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PersonRepository personRepository;

    public void proccess(CommentRequestMessage commentRequestMessage) {
        LocalDateTime currentTime = LocalDateTime.now();
        Person person = new Person();
        person.setFirstName(commentRequestMessage.getFirstName());
        person.setLastName(commentRequestMessage.getLastName());
        person.setId(commentRequestMessage.getPersonId());
        person.setCreatedTime(currentTime);
        person.setUpdatedTime(currentTime);
        Person dbPerson = personRepository.save(person);

        Comment comment = new Comment();
        comment.setPersonId(dbPerson.getId());
        comment.setComment(commentRequestMessage.getComment());
        comment.setCreatedTime(currentTime);
        comment.setUpdatedTime(currentTime);
        commentRepository.save(comment);
    }


}
