package cn.acey.mvc2cleanarch.models;

import java.util.List;


public class User {
    private List<Integer> roles;
    private Long id;

    public User(long id, List<Integer> roles) {
        this.id = id;
        this.roles = roles;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public Long getId() {
        return id;
    }

    public boolean isTeacher() {
        int teacherRole = 1;
        return roles.contains(teacherRole);
    }
}
