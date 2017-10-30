package kz.sanscrit.todolist.controller;

import kz.sanscrit.todolist.mapper.TodolistMapper;
import kz.sanscrit.todolist.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TodolistController {

    private Logger log = LoggerFactory.getLogger(TodolistController.class);
    private TodolistMapper todolistMapper;

    public TodolistController(TodolistMapper todolistMapper) {
        this.todolistMapper = todolistMapper;
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
        List<Task> todoList = todolistMapper.findAll();
        model.addAttribute("todolist", todoList);
        return "list";
    }

    @GetMapping("/add")
    public String addForm(Task task) {
        return "addTask";
    }

    @PostMapping("/add")
    public String addTask(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTask";
        } else {
            todolistMapper.createTask(task);
            log.info("Task " + task.getTaskname() + " added");
            return "redirect:/list";
        }
    }

    @RequestMapping("/done/{id}")
    public String setDoneTask(@PathVariable("id") int id) {
        todolistMapper.setDone(id);
        return "redirect:/list";
    }

    @RequestMapping("/remove/{id}")
    public String removeTask(@PathVariable("id") int id) {
        todolistMapper.removeById(id);
        log.info("Task id:" + id + " removed");
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable("id") int id, Model model) {
        Task task = todolistMapper.getTask(id);
        model.addAttribute("task", task);
        return "editTask";
    }

    @PostMapping("/edit")
    public String editTask(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTask";
        } else {
            todolistMapper.updateTask(task);
            return "redirect:/list";
        }
    }
}
