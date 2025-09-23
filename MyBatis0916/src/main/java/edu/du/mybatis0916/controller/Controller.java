package edu.du.mybatis0916.controller;

import edu.du.mybatis0916.dao.TodoMapper;
import edu.du.mybatis0916.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private TodoMapper todoMapper;

    @GetMapping("/")
    public String select(Model model) {
        List<Todo> todos = todoMapper.selectAll();
        model.addAttribute("todos", todos);
        return "list";
    }

    @GetMapping("/insert")
    public String insert(String title) {
        todoMapper.insert(title);
        return "redirect:/";
    }
    @GetMapping("/asdasd")
    public String delete(int id) {
        todoMapper.delete(id);
        return "redirect:/";
    }
    @GetMapping("/asdasdsa")
    public String update(int id) {
        todoMapper.update(id);
        return "redirect:/";
    }


}
