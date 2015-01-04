/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.CourierDao;
import com.muciek.systemkurierski.models.Courier;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
public class CourierServiceImpl implements CourierService{
    
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
        getCourierDao().addCourier(courier);
    }

    @Override
    public void deleteCourier(Courier courier) {
        getCourierDao().deleteCourier(courier);
    }

    @Override
    public void updateCourier(Courier courier) {
        getCourierDao().updateCourier(courier);
    }

    @Override
    public Courier getCourierById(String id) {
        return getCourierDao().getCourierById(id);
    }

    @Override
    public List<Courier> getAllCouriers() {
        return getCourierDao().getAllCouriers();
    }
}
