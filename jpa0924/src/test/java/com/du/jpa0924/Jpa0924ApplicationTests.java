package com.du.jpa0924;

import com.du.jpa0924.entity.MyData;
import com.du.jpa0924.repository.MyDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Jpa0924ApplicationTests {
    @Autowired
    private MyDataRepository myDataRepository;

    @Test
    void contextLoads() {
        MyData myData = MyData.builder()
                .name("김하나")
                .age(21)
                .email("kim@korea.com")
                .memo("연습입니다2")
                .build();
        myDataRepository.save(myData);  //insert

    }
    @Test
    void contextLoads_findById() {
        Optional<MyData> myData = myDataRepository.findById(1L);
        System.out.println(myData.get().getName());
    }

    @Test
    void contextLoads_findAll() {
        List<MyData> myData = myDataRepository.findAll();
        for ( MyData myData1 : myData){
            System.out.println(myData1);
        }

    }
}
