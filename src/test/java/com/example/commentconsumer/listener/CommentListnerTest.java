package com.example.commentconsumer.listener;

import com.example.commentconsumer.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class CommentListnerTest {
    @InjectMocks
    private CommentListner commentListner;
    @Mock
    private CommentService commentService;

    @Test
    public void test() {
        String json = "{\n" +
                "  \"personId\":\"12\",\n" +
                "  \"firstName\":\"test\"\n" +
                "}";
        Message message = new Message(json.getBytes(), null);
        ;
        commentListner.onMessage(message);
        Mockito.verify(commentService, Mockito.times(1)).proccess(Mockito.any());
    }
    @Test
    public void testInvalidJson() {
        String json = "{\n" +
                "  \"personId\":\"12\",\n" +
                "  \"firstName\"\"test\"\n" +
                "}";
        Message message = new Message(json.getBytes(), null);
        ;
        commentListner.onMessage(message);
        Mockito.verify(commentService, Mockito.times(0)).proccess(Mockito.any());
    }
}
