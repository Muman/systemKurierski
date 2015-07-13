/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Location;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
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
@Transactional
public class CourierDaoImpl implements CourierDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Courier courier) {
        getSessionFactory().getCurrentSession().save(courier);
    }

    @Override
    public void delete(Courier courier) {
        courier.setActive(false);
        update(courier);
    }

    @Override
    public void update(Courier courier) {
        getSessionFactory().getCurrentSession().update(courier);
    }

    @Override
    public Courier getById(int id) {
        Courier courier = null;
        courier = (Courier) sessionFactory.getCurrentSession().get(Courier.class, id);
        return courier;
    }

    @Override
    public List<Courier> getAll() {
        List list = getSessionFactory().getCurrentSession().createQuery("from Courier c where c.active = true").list();
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

    @Override
    public Courier getCourierByLogin(String login) {
        List<Courier> couriers = new ArrayList<>();

        couriers = getSessionFactory().getCurrentSession().createQuery("from Courier where login=?")
                .setParameter(0, login).list();

        if (couriers.size() > 0) {
            return couriers.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Courier> getAllForLocation(Location location) {
        List<Courier> couriersInLocation = new ArrayList<>();

        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Courier.class).add(Restrictions.eq("location_id", location.getId()));
        couriersInLocation = criteria.list();
        return couriersInLocation;
    }
}
