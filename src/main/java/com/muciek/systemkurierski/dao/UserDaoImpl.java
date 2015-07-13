/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muman
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public User findByUserName(String username) {

        List<User> users = new ArrayList<>();

        users = getSessionFactory().getCurrentSession().createQuery("from User where username=? and active=true")
                .setParameter(0, username).list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public void addUser(User newUser) {
        getSessionFactory().getCurrentSession().save(newUser);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        List list = getSessionFactory().getCurrentSession().createQuery("from User").list();
        return list;
    }

    @Override
    public List<User> getAllActiveUsers() { //todo
        List list = getSessionFactory().getCurrentSession().createQuery("from User where active = true").list();
        return list;
    }

    @Override
    public void deleteUser(User user) {
        user.setActive(false);
        updateUser(user);
    }

    @Override
    public void updateUser(User user) {
        getSessionFactory().getCurrentSession().update(user);
    }
}
