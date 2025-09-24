package com.du.post0924.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Comment {
    private long id;
    private long postId;
    private String writer;
    private String content;
    private LocalDateTime createdAt;
}
