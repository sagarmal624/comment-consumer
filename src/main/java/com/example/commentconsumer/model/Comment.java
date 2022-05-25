package com.example.commentconsumer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "comment")
public class Comment {
    @Id
    private String id;
    @Indexed
    private String personId;
    private String comment;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}

