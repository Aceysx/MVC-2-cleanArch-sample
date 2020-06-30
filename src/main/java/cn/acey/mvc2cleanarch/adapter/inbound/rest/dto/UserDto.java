package cn.acey.mvc2cleanarch.adapter.inbound.rest.dto;

import java.util.List;


public class UserDto {
    private List<Integer> roles;
    private Long id;

    public UserDto(long id, List<Integer> roles) {
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
