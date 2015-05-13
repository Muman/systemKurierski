/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Location;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface CourierService {
    public void addCourier(Courier courier);

    public void deleteCourier(Courier courier);

    public void updateCourier(Courier courier);

    public Courier getCourierById(int id);
    
    public Courier getCourierByLogin(String login);
    
    public List<Courier> getAllCouriers();
    
    public List<Courier> getAllCouriersForLocation(Location location);
}
