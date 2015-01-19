/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Location;
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
public class LocationDaoImpl implements LocationDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Location location) {
            getSessionFactory().getCurrentSession().save(location);
    }

    @Override
    public void delete(Location location) {
               getSessionFactory().getCurrentSession().delete(location);
    }

    @Override
    public void update(Location location) {
         getSessionFactory().getCurrentSession().update(location);
    }

    @Override
    public Location getById(int id) {
        Location location = null;
        location = (Location)sessionFactory.getCurrentSession().get(Location.class, id);
        return location;   
    }

    @Override
    public List<Location> getAll() {
        List list = getSessionFactory().getCurrentSession().createQuery("from Location").list();
        return list;
    }
}
