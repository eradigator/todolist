package kz.greetgo.school.controller;

import kz.greetgo.school.mapper.StudentMapper;
import kz.greetgo.school.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private StudentMapper studentMapper;

    public StudentController(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/list";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/list")
    public String studentsList(Model model) {
        List<Student> studentsList = studentMapper.findAll();
        model.addAttribute("studentsList", studentsList);
        return "students";
    }

    @GetMapping("/add")
    public String addForm(Student student) {
        return "addStudent";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addStudent";
        } else {
            studentMapper.createStudent(student);
            return "redirect:/list";
        }
    }

    @RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id) {
        studentMapper.removeById(id);
        return "redirect:/list";
    }
}
