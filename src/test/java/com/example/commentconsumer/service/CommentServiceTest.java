package com.example.commentconsumer.service;

import com.example.commentconsumer.model.CommentRequestMessage;
import com.example.commentconsumer.model.Person;
import com.example.commentconsumer.repository.CommentRepository;
import com.example.commentconsumer.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {
    @InjectMocks
    private CommentService commentService;
    @Mock
    private CommentRepository commentRepository;

    @Mock
    private PersonRepository personRepository;

    @Test
    public void test() {
        CommentRequestMessage commentRequestMessage=new CommentRequestMessage();
        commentRequestMessage.setComment("test");
        commentRequestMessage.setFirstName("FirstName");
        commentRequestMessage.setLastName("LastName");
        Person person=new Person();
        person.setId("123");
        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(person);
        commentService.proccess(commentRequestMessage);
    }
}
