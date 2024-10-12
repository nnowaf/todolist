package com.todolist.test.todolist.dao;

import com.todolist.test.todolist.dto.CheckListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CheckListDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(CheckListDto checklist) {
        String sql = "INSERT INTO checklists (title, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, checklist.getTitle(), checklist.getUserId());
    }

    public List<CheckListDto> findAllByUserId(Long userId) {
        String sql = "SELECT id, title, user_id FROM checklists WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> new CheckListDto(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getLong("user_id")
        ));
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM checklists WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
