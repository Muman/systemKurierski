/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.PackageOption;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muman
 */
@Repository
public class PackageOptionDaoImpl implements PackageOptionDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(PackageOption packageOption) {
        getSessionFactory().getCurrentSession().save(packageOption);
    }

    @Override
    public void delete(PackageOption packageOption) {
        getSessionFactory().getCurrentSession().delete(packageOption);
    }

    @Override
    public void update(PackageOption packageOption) {
        getSessionFactory().getCurrentSession().update(packageOption);
    }

    @Override
    public PackageOption getById(int id) {
        PackageOption packageOption = (PackageOption) sessionFactory.
                getCurrentSession().get(PackageOption.class, id);
        return packageOption;
    }

    @Override
    public List<PackageOption> getAll() {
        List list = getSessionFactory().getCurrentSession().
                createQuery("from PackageOption").list();
        return list;
    }
}
