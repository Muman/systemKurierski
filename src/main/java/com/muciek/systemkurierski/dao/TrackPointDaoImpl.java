/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.TrackPoint;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muman
 */
@Repository
public class TrackPointDaoImpl implements TrackPointDao{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void add(TrackPoint trackPoint) {
        getSessionFactory().getCurrentSession().save(trackPoint);
    }

    @Override
    public void delete(TrackPoint trackPoint) {
        getSessionFactory().getCurrentSession().delete(trackPoint);
    }

    @Override
    public void update(TrackPoint trackPoint) {
        getSessionFactory().getCurrentSession().update(trackPoint);
    }

    @Override
    public TrackPoint getById(int id) {
        TrackPoint trackPoint = null;
        trackPoint = (TrackPoint)sessionFactory.getCurrentSession().get(TrackPoint.class, id);
        return trackPoint;   
    }
    
}
