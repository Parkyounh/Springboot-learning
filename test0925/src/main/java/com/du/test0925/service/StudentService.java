package com.du.test0925.service;

import com.du.test0925.domain.Student;
import com.du.test0925.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentMapper studentMapper;

    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    public Student selectById(int id) {
        return studentMapper.selectById(id);
    }

    public Student selectByPhone(String phone) {
        return studentMapper.selectByPhone(phone);
    }

    public int insert(Student student) {

        if(selectByPhone(student.getPhone())!=null){
            return 1;
        }else if (student.getName()==null || student.getName()=="") {
            return 2;
        } else if (student.getPhone().length() != 13) {
            return 3;
        }
        else{
            studentMapper.insert(student);
            return 0;
        }
    }

    public int update(Student student) {
        LocalDateTime now = LocalDateTime.now();
        Date nowDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        student.setAddDate(nowDate);

        if(selectByPhone(student.getPhone())!=null){
            return 1;
        }else if (student.getName()==null || student.getName()=="") {
            return 2;
        }else if (student.getPhone().length() != 13) {

            return 3;
        }
        else{
            System.out.println(student.getName());
            studentMapper.update(student);
            return 0;
        }
    }

    public void delete(int id) {
        studentMapper.delete(id);
    }
}
