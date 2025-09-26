package com.du.jpa0926;

import com.du.jpa0926.entity.Post;
import com.du.jpa0926.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Jpa0926ApplicationTests {

    @Autowired
    private PostRepository postRepository;

    @Test
    void insertPost() {
        Post post = Post.builder().title("제목2").content("내용2").author("이름2").build();
        postRepository.save(post);
    }

    @Test
    void findById() {
        Optional<Post> post = postRepository.findById(2L);
        System.out.println(post);
    }

    @Test
    void findAll() {
        List<Post> posts = postRepository.findAll();
        for (Post post : posts) {
            System.out.println(post);
        }
    }

    @Test
    void Update() {
        Post post = postRepository.findById(2L).get();
        post.setAuthor("변경됨");
        postRepository.save(post);
    }

    @Test
    void delete() {
        postRepository.deleteById(2L);
    }
}
