/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Courier;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muman
 */
@Repository
@Transactional
public class CourierDaoImpl implements CourierDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void addCourier(Courier courier) {
        getSessionFactory().getCurrentSession().save(courier);
    }

    @Override
    public void deleteCourier(Courier courier) {
        getSessionFactory().getCurrentSession().delete(courier);
    }

    @Override
    public void updateCourier(Courier courier) {
        getSessionFactory().getCurrentSession().update(courier);
    }

    @Override
    public Courier getCourierById(int id) {
        Courier courier = null;
        courier = (Courier)sessionFactory.getCurrentSession().get(Courier.class, id);
        return courier;   
    }

    @Override
    public List<Courier> getAllCouriers() {
        List list = getSessionFactory().getCurrentSession().createQuery("from Courier").list();
        return list;
    }

    /**
     * @return the SessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param SessionFactory the SessionFactory to set
     */
    public void setSessionFactory(SessionFactory SessionFactory) {
        this.sessionFactory = SessionFactory;
    }
    
}