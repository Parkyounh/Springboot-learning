package com.du.fileupload1001.repository;

import com.du.fileupload1001.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager em;

    public List<StudentEntity> findAll(){
        return em.createQuery("from StudentEntity", StudentEntity.class).getResultList();
    }

    public StudentEntity findById(Long id){
        return em.find(StudentEntity.class, id);
    }

    public void save(StudentEntity studentEntity){
        em.persist(studentEntity);
    }

    public void delete(Long id){
        StudentEntity studentEntity1 = em.find(StudentEntity.class, id);
        if(studentEntity1 != null){
            em.remove(studentEntity1);
        }
    }

    public void update(StudentEntity studentEntity){
        em.merge(studentEntity);
    }
}
