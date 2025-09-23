package edu.du.demo0916.dao;

import edu.du.demo0916.model.Todo;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Select("SELECT * FROM todos")
    List<Todo> findAll();

}
