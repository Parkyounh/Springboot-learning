package com.du.query1013.repository;

import com.du.query1013.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

//    List<Post> findByTitle(String title);      // JPA Query method 방식 - 자동 생성
//    List<Post> findByTitleContaining(String keyword);
//
//
//    @Query("select p from Post p where p.title = :title")
//    List<Post> findByTitle(@Param("title") String title);
//
    @Query("select p from Post p where p.title like %:keyword%")
    List<Post> findByTitleContaining(@Param("keyword") String keyword);

//    @Query("select p from Post p where p.title like concat('%', :keyword, '%')")
//    List<Post> findByTitleContaining(@Param("keyword") String keyword);
}
