package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save( User user ) {
        userDao.save(user);
    }

    @Override
    public void update( User user ) {
        userDao.update(user);
    }

    @Override
    public void delete( int id ) {
        userDao.delete(id);
    }

    @Override
    public User getById( int id ) {
        return userDao.getById(id);
    }
}
