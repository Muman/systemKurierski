/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Courier;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface CourierDao {
    public void addCourier(Courier courier);

    public void deleteCourier(Courier courier);

    public void updateCourier(Courier courier);

    public Courier getCourierById(int id);
    
    public List<Courier> getAllCouriers();
}
