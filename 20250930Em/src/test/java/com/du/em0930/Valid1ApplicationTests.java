package com.du.em0930;

import com.du.em0930.entity.MyUser;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Valid1ApplicationTests {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Test
    @Transactional
    void contextLoads() {
        MyUser myUser = MyUser.builder().name("김하나").email("ads@korea.com").password("123456").build();
        em.persist(myUser); //영속성 생성 - DB 연결

        MyUser myUser2 = em.find(MyUser.class, myUser.getId());
        System.out.println(myUser2);
    }


    //@Transactional을 사용하지 않고 DB에 커밋하는 방식으로 테스트
    @Test
    void testPresist(){
        EntityManager em2 = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em2.getTransaction();

        transaction.begin();

        MyUser myUser = MyUser.builder().name("관리자").email("admin@korea.com").password("123456").build();
        MyUser myUser2 = MyUser.builder().name("김광규").email("kgg@korea.com").password("123456").build();
        MyUser myUser3 = MyUser.builder().name("홍길동").email("hgd@korea.com").password("123456").build();
        MyUser myUser4 = MyUser.builder().name("김하나").email("khn@korea.com").password("123456").build();


        em2.persist(myUser); //영속성 생성 - DB 연결
        em2.persist(myUser2);
        em2.persist(myUser3);
        em2.persist(myUser4);

        myUser.setName("테스트");   //update를 하지 않았지만 이름이 바뀜

        em2.flush();
        transaction.commit();

        em2.close();
    }


    @Test
    void testFind(){
        EntityManager em2 = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em2.getTransaction();

        transaction.begin();

        MyUser myUser = em2.find(MyUser.class, 1L);
        myUser.setName("박윤호");
        System.out.println(myUser);

        em2.flush();
        transaction.commit();

        em2.close();
    }

    @Test
    void testMerge(){  //update
        EntityManager em2 = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em2.getTransaction();

        transaction.begin();

        MyUser myUser = MyUser.builder().id(1L).name("관리자").email("admin@korea.com").password("123456").build();

        em2.merge(myUser); //영속성 생성 - DB 연결

        myUser.setName("테스트");   //update를 하지 않았지만 이름이 바뀜

        em2.flush();
        transaction.commit();

        em2.close();
    }

    @Test
    void testRemove(){
        EntityManager em2 = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em2.getTransaction();

        transaction.begin();

        MyUser myUser = em2.find(MyUser.class, 5L);
        em2.remove(myUser);

        em2.flush();
        transaction.commit();

        em2.close();
    }

    @Test
    void testSelectAll(){
        EntityManager em2 = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em2.getTransaction();

        transaction.begin();

        List<MyUser> list = em2.createQuery("select e from MyUser e", MyUser.class).getResultList();
        for (MyUser myUser : list) {
            System.out.println(myUser);
            myUser.setName(myUser.getName()+1);
        }

        em2.flush();
        transaction.commit();

        em2.close();
    }

}
