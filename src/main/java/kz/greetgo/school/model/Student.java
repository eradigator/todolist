package kz.greetgo.school.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

    private Integer id;

    @NotNull
    @Size(min = 2, max = 30)
    private String firstname;

    @NotNull
    @Size(min = 1, max = 30)
    private String lastname;

    @NotNull
    @Size(min = 1, max = 10)
    private String course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
