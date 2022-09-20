package com.kata.PP_31._Spring_Boot.service;

import com.kata.PP_31._Spring_Boot.dao.UserDao;
import com.kata.PP_31._Spring_Boot.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

}
