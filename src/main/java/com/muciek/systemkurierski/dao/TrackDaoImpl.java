/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Track;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muman
 */
@Repository
public class TrackDaoImpl implements TrackDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void add(Track track) {
        getSessionFactory().getCurrentSession().save(track);
    }

    @Override
    public void delete(Track track) {
        getSessionFactory().getCurrentSession().delete(track);
    }

    @Override
    public void update(Track track) {
        getSessionFactory().getCurrentSession().update(track);
    }

    @Override
    public Track getById(int id) {
        Track track = null;
        track = (Track)sessionFactory.getCurrentSession().get(Track.class, id);
        return track;   
    }  

    @Override
    public List<Track> getByCourier(Courier courier) {
        List<Track> resultList = new ArrayList<>();
//        resultList = getSessionFactory().getCurrentSession().createCriteria(Track.class).add(Restrictions.eq("courier_id", courier.getId())).list();
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Track.class).createAlias("courier", "c").add(Restrictions.eq("c.id", courier.getId()));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY); 
        resultList = criteria.list();
        return resultList;
    }

    @Override
    public List<Track> getAll() {
//        List list = getSessionFactory().getCurrentSession().createCriteria(Track.class).list();
       List list = getSessionFactory().getCurrentSession().createQuery("from Track").list();
        return list;
    }
}
