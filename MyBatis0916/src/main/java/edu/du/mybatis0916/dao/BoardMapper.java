package edu.du.mybatis0916.dao;

import edu.du.mybatis0916.model.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("select * from board")
    public List<Board> selectAll();

    @Select("select * from borad where id=#{id}")
    public Board selectById(int id);

    @Insert("insert into board (title,content) values (#{title},#{content})")
    public void insert(Board board);

    @Delete("delete from board where id=#{id}")
    public void delete(int id);

    @Update("update board set title=#{title},content=#{content} where id=#{id}")
    public void update(Board board);

}
