package kz.greetgo.school.mapper;

import kz.greetgo.school.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM students WHERE deleted IS NOT TRUE")
    List<Student> findAll();

    @Insert("INSERT INTO students (firstname,lastname,course) VALUES (#{firstname},#{lastname},#{course})")
    void createStudent(Student student);

    @Update("UPDATE students SET deleted = TRUE WHERE id=#{id}")
    void removeById(int id);
}
