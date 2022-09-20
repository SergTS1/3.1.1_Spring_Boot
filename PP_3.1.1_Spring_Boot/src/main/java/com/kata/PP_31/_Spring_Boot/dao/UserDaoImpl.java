package com.kata.PP_31._Spring_Boot.dao;

import com.kata.PP_31._Spring_Boot.entity.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public User getUser(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
