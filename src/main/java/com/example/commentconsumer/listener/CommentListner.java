package com.example.commentconsumer.listener;


import com.example.commentconsumer.model.CommentRequestMessage;
import com.example.commentconsumer.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommentListner implements MessageListener {
    @Autowired
    private CommentService commentService;

    public void onMessage(Message message) {
        try {
            log.info("recevied message from rabbitmq=>{}",new String(message.getBody()));
            ObjectMapper objectMapper = new ObjectMapper();
            CommentRequestMessage commentRequestMessage = objectMapper.readValue(message.getBody(), CommentRequestMessage.class);
            commentService.proccess(commentRequestMessage);
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }

}