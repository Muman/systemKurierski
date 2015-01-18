/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.UserRole;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muman
 */
@Repository
public class UserRoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUserRole(UserRole userRole) {
        getSessionFactory().getCurrentSession().save(userRole);
    }

    public void deleteUserRole(UserRole userRole) {
        getSessionFactory().getCurrentSession().delete(userRole);
    }

    public void updateUserRole(UserRole userRole) {
        getSessionFactory().getCurrentSession().update(userRole);
    }

    public UserRole getUserRoleById(int id) {
        UserRole userRole = (UserRole) sessionFactory.getCurrentSession().get(UserRole.class, id);
        return userRole;
    }

    public List<UserRole> getAllUserRoles() {
        List list = getSessionFactory().getCurrentSession().createQuery("from UserRole").list();
        return list;
    }
}
