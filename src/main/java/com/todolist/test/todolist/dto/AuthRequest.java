package com.todolist.test.todolist.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AuthRequest {

    private String username;
    private String password;
}
