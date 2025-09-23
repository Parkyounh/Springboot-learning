package com.du.mybatis0917;

import com.du.mybatis0917.dao.BoardMapper;
import com.du.mybatis0917.model.Board;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MyBatis0917ApplicationTests {

    @Autowired
    private BoardMapper boardMapper;


    @Test
    void 테스트(){
        List<Board> boards = boardMapper.findAll();
        for (Board board : boards) {
            System.out.println(board);
        }
    }
    
    @Test
    void testInsertAndFindById(){
        //given
        Board board = new Board();
        board.setTitle("테스트 제목");
        board.setContent("테스트 내용");

        //when
        boardMapper.insert(board); //insert
        List<Board> boards = boardMapper.findAll();
        Board board1 = boards.get(0);
        
        //then
        assertThat(board1.getTitle()).isEqualTo("테스트 제목");
        assertThat(board1.getContent()).isEqualTo("테스트 내용");
    }
    
    @Test
    void testUpdate(){
        Board board = new Board();
        board.setTitle("원래 제목");
        board.setContent("원래 내용");
        boardMapper.insert(board);

        Board board2 = boardMapper.findAll().get(0);
        board2.setTitle("수정된 제목");
        board2.setContent("수정된 제목");

        boardMapper.update(board2);
        Board updated = boardMapper.findById(board2.getId());

        assertThat(updated.getTitle()).isEqualTo(board2.getTitle());
        assertThat(updated.getContent()).isEqualTo(board2.getContent());

    }
    
    
    @Test
    void testDelete(){  
        Board board = new Board();
        board.setTitle("삭제용 제목");
        board.setTitle("삭제용 내용");
        boardMapper.insert(board);

        Board board2 = boardMapper.findAll().get(0);
        boardMapper.delete(board2.getId());

        Board board3 = boardMapper.findById(board2.getId());
        assertThat(board3).isNull();
    }





}
