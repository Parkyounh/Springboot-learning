package com.du.query1013.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
