package com.du.test0925.controller;

import com.du.test0925.domain.Student;
import com.du.test0925.mapper.StudentMapper;
import com.du.test0925.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public String list(Model model) {
        List<Student> list = studentService.selectAll();
        model.addAttribute("student", list);
        return "list";
    }

    @PostMapping("/new")
    public String newStudent(Student student, Model model) {
        int result = studentService.insert(student);
        if(result == 0) {
            return "redirect:/";
        }else{
            model.addAttribute("error", result);
            List<Student> list = studentService.selectAll();
            model.addAttribute("student", list);
            return "list";
        }
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Student student = studentService.selectById(id);
        model.addAttribute("one", student);
        return "detail";
    }

    @PostMapping("/update")
    public String updateStudent(Student student,Model model) {
        int result = studentService.update(student);
        if(result == 0) {
            return "redirect:/";
        }else{
            model.addAttribute("one", studentService.selectById(student.getId()));
            model.addAttribute("error", result);
            return "detail";
        }
    }

    @PostMapping("/delete")
    public String deleteStudent(int id) {
        studentService.delete(id);
        return "redirect:/";
    }
}
