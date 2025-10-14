package com.du.rest01.dto;


import com.du.rest01.entity.User;
import lombok.Getter;

@Getter
public class UserDto {
    private Long id;
    private String name;
    private String email;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}

