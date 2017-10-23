package com.example.dao;

import com.example.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void save(User user);
    User getById(int id);
    void delete (int id);
    void update(User user);
}
