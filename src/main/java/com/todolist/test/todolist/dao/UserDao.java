package com.todolist.test.todolist.dao;

import com.todolist.test.todolist.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Menyimpan pengguna baru
    public void save(UserDto user) {
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    // Menemukan pengguna berdasarkan username
    public UserDto findByUsername(String username) {
        String sql = "SELECT id, username, password, email FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            UserDto user = new UserDto();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            return user;
        }, username);
    }
}
