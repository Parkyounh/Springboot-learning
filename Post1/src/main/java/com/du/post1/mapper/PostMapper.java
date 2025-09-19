package com.du.post1.mapper;

import com.du.post1.domain.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("select * from post")
    public List<Post> selectAll();

    @Select("select * from post where id =#{id}")
    public Post selectById(Long id);

    @Insert("insert into post(title,content,writer) values (#{title},#{content},#{writer})")
    @Options(useGeneratedKeys = true, keyProperty = "id")   //auto increment의 id 값을 넘겨줌
    public void insert(Post post);

    @Update("UPDATE post set title =#{title}, content=#{content}, writer=#{writer} where id=#{id}")
    public void update(Post post);

    @Delete("delete from post where id=#{id}")
    public void delete(Long id);
}
