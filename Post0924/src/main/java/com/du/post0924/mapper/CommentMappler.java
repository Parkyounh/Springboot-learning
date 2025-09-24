package com.du.post0924.mapper;


import com.du.post0924.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMappler {
    @Select("select * from comment where post_id =#{postId} order by created_at ASC")
    List<Comment> findByPostId(@Param("postId") Long postId);

    @Insert("insert into comment(post_id,writer,content) values (#{postId},#{writer},#{content})")
    void insert(Comment comment);
}

