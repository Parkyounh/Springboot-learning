package com.du.test0925.mapper;

import com.du.test0925.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student")
    List<Student> selectAll();

    @Select("SELECT * FROM student where id =#{id}")
    Student selectById(int id);

    @Select("SELECT * from student where phone =#{phone}")
    Student selectByPhone(String phone);

    @Insert("INSERT INTO student (name,phone) values (#{name},#{phone})")
    void insert(Student student);

    @Update("UPDATE student set name=#{name},phone=#{phone}, add_date =#{addDate} where id=#{id}")
    void update(Student student);

    @Delete("delete from student where id =#{id} ")
    void delete(int id);
}
