package edu.du.mybatis0916.dao;

import edu.du.mybatis0916.model.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("select * from todos")
    public List<Todo> selectAll();

    @Insert("insert into todos (title) values (#{title})")
    public void insert(String title);

    @Delete("delete from todos where id=#{id}")
    public void delete(int id);

    @Update("update todos set completed=not completed where id=#{id}")
    public void update(int id);
}
