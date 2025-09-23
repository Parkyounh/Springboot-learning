//package edu.du.mybatis0916.controller;
//
//import edu.du.mybatis0916.dao.BoardMapper;
//import edu.du.mybatis0916.model.Board;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class BoardController {
//
//    private final BoardMapper boardMapper;
//
//    public BoardController(BoardMapper boardMapper) {
//        this.boardMapper = boardMapper;
//    }
//
//    @GetMapping("/")
//    public String list(Model model){
//        List<Board> boards = boardMapper.selectAll();
//        model.addAttribute("boards",boards);
//        return "list";
//    }
//}
