package com.todolist.test.todolist.controller;


import com.todolist.test.todolist.dto.ItemDto;
import com.todolist.test.todolist.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody ItemDto item) {
        itemService.createItem(item);
        return ResponseEntity.ok("Item created successfully");
    }

    @GetMapping("/{checklistId}")
    public ResponseEntity<List<ItemDto>> getItems(@PathVariable Long checklistId) {
        List<ItemDto> items = itemService.getItemsByChecklistId(checklistId);
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok("Item deleted successfully");
    }
}
