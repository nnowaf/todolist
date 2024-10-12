package com.todolist.test.todolist.dao;

import com.todolist.test.todolist.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(ItemDto item) {
        String sql = "INSERT INTO items (description, completed, checklist_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, item.getDescription(), item.isCompleted(), item.getChecklistId());
    }

    public List<ItemDto> findAllByChecklistId(Long checklistId) {
        String sql = "SELECT id, description, completed, checklist_id FROM items WHERE checklist_id = ?";
        return jdbcTemplate.query(sql, new Object[]{checklistId}, (rs, rowNum) ->
                new ItemDto(
                        rs.getLong("id"),
                        rs.getString("description"),
                        rs.getBoolean("completed"),
                        rs.getLong("checklist_id")
                )
        );
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM items WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
