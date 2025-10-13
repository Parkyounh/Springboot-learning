package com.du.query1013.util;

import com.du.query1013.entity.Post;
import com.du.query1013.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final PostRepository postRepository;

    @PostConstruct
    public void init(){
        postRepository.save(new Post("스프링 부트 시작","시작입니다"));
        postRepository.save(new Post("JPA 기초","Java Persostence API 시작입니다"));
        postRepository.save(new Post("타임 리프 사용법","시작입니다"));
        postRepository.save(new Post("스프링과 JPA","시작입니다"));
        postRepository.save(new Post("테스트 글","시작입니다"));
    }
}
