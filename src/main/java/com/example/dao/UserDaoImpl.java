package com.example.dao;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl( JdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql ="SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void save( User user ) {
        String sql = "INSERT INTO users (firsname, lastname, email, age) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(),user.getLastName(), user.getEmail(), user.getAge());
    }

    @Override
    public User getById( int id ) {
        String sql = "SELECT * FROM users WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public void delete( int id ) {
        String sql="DELETE FROM  users WHERE id =?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void update( User user ) {
        String sql = "UPDATE users SET firstname=?, lastname=?, email=?, age=? WHERE id=?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.getId());
    }

}
