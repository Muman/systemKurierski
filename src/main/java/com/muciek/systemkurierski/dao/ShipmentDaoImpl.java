/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Location;
import com.muciek.systemkurierski.models.Shipment;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muman
 */
@Repository
public class ShipmentDaoImpl implements ShipmentDao{
    
    @Autowired
    private SessionFactory SessionFactory;

    @Override
    public void add(Shipment shipment) {
        getSessionFactory().getCurrentSession().save(shipment);
    }

    @Override
    public void delete(Shipment shipment) {
        getSessionFactory().getCurrentSession().delete(shipment);
    }

    @Override
    public void update(Shipment shipment) {
        getSessionFactory().getCurrentSession().update(shipment);
    }

    @Override
    public Shipment getById(int id) {
        Shipment shipment = (Shipment)getSessionFactory().getCurrentSession().get(Shipment.class,id);
        return shipment;
    }

    @Override
    public List<Shipment> getAll() {
        List list = getSessionFactory().getCurrentSession().createCriteria(Shipment.class).list();
        return list;
    }

    public SessionFactory getSessionFactory() {
        return SessionFactory;
    }

    public void setSessionFactory(SessionFactory SessionFactory) {
        this.SessionFactory = SessionFactory;
    }

    @Override
    public List<Shipment> getAllPackagesForUser(String username) {
        
        //Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Shipment.class).add(Restrictions.eq("username", username));
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Shipment.class).createAlias("user", "u").add(Restrictions.eq("u.username", username));
        
        List<Shipment> userPackages = criteria.list();
        return userPackages;
    }
}
