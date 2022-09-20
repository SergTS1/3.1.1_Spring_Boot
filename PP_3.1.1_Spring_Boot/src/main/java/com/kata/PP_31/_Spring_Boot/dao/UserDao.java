package com.kata.PP_31._Spring_Boot.dao;

import com.kata.PP_31._Spring_Boot.entity.User;
import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteById(int id);

    public void updateUser(User user);
}
