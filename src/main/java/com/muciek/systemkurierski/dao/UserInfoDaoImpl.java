/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.UserInfo;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muman
 */
@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(UserInfo userInfo) {
        getSessionFactory().getCurrentSession().save(userInfo);
    }

    @Override
    public void delete(UserInfo userInfo) {
        getSessionFactory().getCurrentSession().delete(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        getSessionFactory().getCurrentSession().saveOrUpdate(userInfo);
    }

    @Override
    public UserInfo getById(int id) {
        UserInfo userInfo = (UserInfo)sessionFactory.getCurrentSession().get(UserInfo.class, id);
        return userInfo;   
    }

    @Override
    public List<UserInfo> getAll() {
        List list = getSessionFactory().getCurrentSession().createQuery("from UserInfo").list();
        return list;
    }

}
