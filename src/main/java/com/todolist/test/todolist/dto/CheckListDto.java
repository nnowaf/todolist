package com.todolist.test.todolist.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckListDto {
    private Long id;
    private String title;
    private Long userId;  // Foreign key ke User
}
