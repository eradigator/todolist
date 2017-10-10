package kz.greetgo.school.controller;

import kz.greetgo.school.mapper.StudentMapper;
import kz.greetgo.school.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private StudentMapper studentMapper;

    public StudentController(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @RequestMapping("/list")
    public String studentsList(Model model) {
        List<Student> studentsList = studentMapper.findAll();
        model.addAttribute("studentsList",studentsList);
        return "students";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentMapper.createStudent(student);
        return "redirect:/list";
    }

    @RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id) {
        studentMapper.removeById(id);
        return "redirect:/list";
    }
}
