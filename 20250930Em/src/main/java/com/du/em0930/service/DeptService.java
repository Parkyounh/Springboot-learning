package com.du.em0930.service;

import com.du.em0930.entity.Dept;
import com.du.em0930.repository.DeptRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DeptService {

    private final DeptRepository deptRepository;

    public void save(Dept dept){
        deptRepository.save(dept);
    }

    public Dept findById(Long id){
        return deptRepository.findById(id);
    }

    public List<Dept> findAll(){
        return deptRepository.findAll();
    }
}
