package kz.sanscrit.todolist.mapper;

import kz.sanscrit.todolist.model.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TodolistMapper {

    @Select("SELECT * FROM task NATURAL JOIN weekday ORDER BY weekday_id")
    List<Task> findAll();

    @Select("SELECT * FROM task WHERE id = #{id}")
    Task getTask(int id);

    @Insert("INSERT INTO task (taskname,weekday_id) VALUES (#{taskname},#{weekday_id})")
    void createTask(Task task);

    @Update("UPDATE task SET taskname = #{taskname}, weekday_id = #{weekday_id} WHERE id = #{id}")
    void updateTask(Task task);

    @Update("UPDATE task SET done = TRUE WHERE id=#{id}")
    void setDone(int id);

    @Update("DELETE FROM task WHERE id=#{id}")
    void removeById(int id);
}
