/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Recipient;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muman
 */
@Repository
public class RecipientDaoImpl implements RecipientDao{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void add(Recipient recipient) {
        getSessionFactory().getCurrentSession().save(recipient);
    }

    @Override
    public void delete(Recipient recipient) {
        getSessionFactory().getCurrentSession().delete(recipient);
    }

    @Override
    public void update(Recipient recipient) {
        getSessionFactory().getCurrentSession().update(recipient);
    }

    @Override
    public Recipient getById(int id) {
        Recipient recipient = (Recipient)getSessionFactory().getCurrentSession().get(Recipient.class,id);
        return recipient;
    }

    @Override
    public List<Recipient> getAll() {
        List list = getSessionFactory().getCurrentSession().createQuery("from Recipient").list();
        return list;
    }
    
}
