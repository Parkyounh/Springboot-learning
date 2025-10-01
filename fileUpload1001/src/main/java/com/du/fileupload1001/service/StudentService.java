package com.du.fileupload1001.service;

import com.du.fileupload1001.entity.StudentEntity;
import com.du.fileupload1001.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentEntity> findAll(){
        return studentRepository.findAll();
    }
    
    public StudentEntity findById(Long id){
        return studentRepository.findById(id);
    }

    public void deleteById(Long id){
        studentRepository.delete(id);
    }

    public void insert(StudentEntity studentEntity){
        studentRepository.save(studentEntity);
    }

    public void update(StudentEntity studentEntity){
        studentRepository.update(studentEntity);
    }

}
