package com.du.test0925;

import com.du.test0925.domain.Student;
import com.du.test0925.mapper.StudentMapper;
import com.du.test0925.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@SpringBootTest
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class Test0925ApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void selectAll() {
        List<Student> students = studentMapper.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    void selectById() {
        Student student = studentMapper.selectById(1);
        System.out.println(student);
    }

    @Test
    void insert() {
        Student student = new Student();
        student.setName("테스트");
        student.setPhone("010-0000-0000");
        studentMapper.insert(student);
        selectAll();
    }

    @Test
    void update() {
        Student student = new Student();
        student.setId(1);
        student.setName("변경됨");
        studentMapper.update(student);
        student= studentMapper.selectById(1);
        System.out.println(student);
    }

    @Test
    void delete() {
        studentMapper.delete(1);
        studentMapper.delete(2);
        selectAll();
    }




}
