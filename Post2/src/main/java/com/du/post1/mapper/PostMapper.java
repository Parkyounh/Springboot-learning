package com.du.post1.mapper;

import com.du.post1.domain.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("select * from post")
    List<Post> selectAll();

    @Select("select * from post where id =#{id}")
    Post selectById(Long id);

    @Insert("insert into post(title,content,writer) values (#{title},#{content},#{writer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")   //auto increment의 id 값을 넘겨줌
    void insert(Post post);

    @Update("UPDATE post set title =#{title}, content=#{content}, writer=#{writer} where id=#{id}")
    void update(Post post);

    @Delete("delete from post where id=#{id}")
    void delete(Long id);

    @Select("select * from post order by id desc limit #{limit} offset #{offset}")
    List<Post> findPage(@Param("offset") int offset, @Param("limit") int limit);

    @Select("select count(*) from post")
    int count();
}


