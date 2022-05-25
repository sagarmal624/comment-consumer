package com.example.commentconsumer.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CommentRequestMessage {
    private String personId;
    private String firstName;
    private String lastName;
    private String comment;
}
