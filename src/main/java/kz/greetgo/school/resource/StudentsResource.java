package kz.greetgo.school.resource;

import kz.greetgo.school.mapper.StudentMapper;
import kz.greetgo.school.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsResource {
    private StudentMapper studentMapper;

    public StudentsResource(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @GetMapping("/all")
    public List<Student> getAll() {
        return studentMapper.findAll();
    }
}
