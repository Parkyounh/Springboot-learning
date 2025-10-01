package com.du.fileupload1001.util;

import com.du.fileupload1001.entity.StudentEntity;
import com.du.fileupload1001.repository.StudentRepository;
import com.du.fileupload1001.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final StudentService studentService;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        StudentEntity studentEntity = StudentEntity.builder().name("박윤호").phoneNumber("010-5610-2866").build();
        StudentEntity studentEntity2 = StudentEntity.builder().name("홍길동").phoneNumber("010-1234-5678").build();

        studentService.insert(studentEntity);
        studentService.insert(studentEntity2);
    }

}
