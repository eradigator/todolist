package kz.sanscrit.todolist.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Task {

    private Integer id;

    @NotNull
    @Size(min = 2, max = 30)
    private String taskname;

    @NotNull
    private int weekday_id;

    private String weekday_name;

    private boolean done;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public int getWeekday_id() {
        return weekday_id;
    }

    public void setWeekday_id(int weekday_id) {
        this.weekday_id = weekday_id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getWeekday_name() {
        return weekday_name;
    }

    public void setWeekday_name(String weekday_name) {
        this.weekday_name = weekday_name;
    }
}
