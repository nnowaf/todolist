package com.todolist.test.todolist.controller;

import com.todolist.test.todolist.dto.CheckListDto;
import com.todolist.test.todolist.services.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checklists")
public class CheckListController {


    @Autowired
    private CheckListService checklistService;

    @PostMapping
    public ResponseEntity<String> createChecklist(@RequestBody CheckListDto checklist) {
        checklistService.createChecklist(checklist);
        return ResponseEntity.ok("Checklist created successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CheckListDto>> getChecklists(@PathVariable Long userId) {
        List<CheckListDto> checklists = checklistService.getChecklistsByUserId(userId);
        return ResponseEntity.ok(checklists);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChecklist(@PathVariable Long id) {
        checklistService.deleteChecklist(id);
        return ResponseEntity.ok("Checklist deleted successfully");
    }
}
