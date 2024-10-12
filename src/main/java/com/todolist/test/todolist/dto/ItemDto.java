package com.todolist.test.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDto {
    private Long id;
    private String description;
    private boolean completed;
    private Long checklistId;  // Foreign key ke Checklist
}
