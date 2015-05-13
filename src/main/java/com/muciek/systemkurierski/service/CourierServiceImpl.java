/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.CourierDao;
import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Location;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
@Transactional
public class CourierServiceImpl implements CourierService{
    
    @Autowired
    private CourierDao courierDao;

    /**
     * @return the courierDao
     */
    public CourierDao getCourierDao() {
        return courierDao;
    }

    /**
     * @param courierDao the courierDao to set
     */
    public void setCourierDao(CourierDao courierDao) {
        this.courierDao = courierDao;
    }

    @Override
    public void addCourier(Courier courier) {
        getCourierDao().add(courier);
    }

    @Override
    public void deleteCourier(Courier courier) {
        getCourierDao().delete(courier);
    }

    @Override
    public void updateCourier(Courier courier) {
        getCourierDao().update(courier);
    }

    @Override
    public Courier getCourierById(int id) {
        return getCourierDao().getById(id);
    }

    @Override
    public List<Courier> getAllCouriers() {
        List<Courier> allCouriers = getCourierDao().getAll();
        
        return allCouriers;
    }

    @Override
    public Courier getCourierByLogin(String login) {
        return getCourierDao().getCourierByLogin(login);
    }

    @Override
    public List<Courier> getAllCouriersForLocation(Location location) {
        return getCourierDao().getAllForLocation(location);
    }
}
