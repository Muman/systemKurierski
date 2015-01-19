/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.PackageStatus;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muman
 */
@Repository
public class PackageStatusDaoImpl implements PackageStatusDao{
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(PackageStatus packageStatus) {
        getSessionFactory().getCurrentSession().save(packageStatus);
    }

    @Override
    public void delete(PackageStatus packageStatus) {
        getSessionFactory().getCurrentSession().delete(packageStatus);
    }

    @Override
    public void update(PackageStatus packageStatus) {
        getSessionFactory().getCurrentSession().update(packageStatus);
    }

    @Override
    public PackageStatus getById(int id) {
        PackageStatus packageStatus = (PackageStatus)getSessionFactory().getCurrentSession().get(PackageStatus.class,id);
        return packageStatus;
    }

    @Override
    public List<PackageStatus> getAll() {
        List list = getSessionFactory().getCurrentSession().createQuery("from PackageStatus").list();
        return list;
    }
}